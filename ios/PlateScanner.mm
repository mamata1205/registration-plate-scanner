//
//  PlateScanner.m
//  RNplatescanner
//
//  Created by Evan Rosenfeld on 2/24/17.
//  Copyright © 2017 CarDash. All rights reserved.
//

#import "PlateScanner.h"
#import <platescanner/alpr.h>


static PlateScanner *scanner;
@implementation PlateScanner {
    alpr::Alpr* delegate;
}

+ (instancetype)sharedInstance {
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        scanner = [[self class] new];
    });
    return scanner;
}

- (instancetype) init {
    if (self = [super init]) {
        delegate = new alpr::Alpr(
          [@"us" UTF8String],
          [[[NSBundle mainBundle] pathForResource:@"platescanner.conf" ofType:nil] UTF8String],
          [[[NSBundle mainBundle] pathForResource:@"runtime_data" ofType:nil] UTF8String]
        );
        delegate->setTopN(1);
        
        if (delegate->isLoaded() == false) {
            NSLog(@"Error initializing platescanner library");
            delegate = nil;
        }
        if (!delegate) self = nil;
    }
    return self;
    
}

- (void) setCountry:(NSString *)country {
    delegate->setCountry([country UTF8String]);
}

- (void)scanImage:(cv::Mat &)colorImage
        onSuccess:(onPlateScanSuccess)success
        onFailure:(onPlateScanFailure)failure {
    
    if (delegate->isLoaded() == false) {
        NSError *error = [NSError errorWithDomain:@"alpr" code:-100
                                         userInfo:[NSDictionary dictionaryWithObject:@"Error loading platescanner" forKey:NSLocalizedDescriptionKey]];
        failure(error);
    }
    
    std::vector<alpr::AlprRegionOfInterest> regionsOfInterest;
    alpr::AlprResults alprResults = delegate->recognize(colorImage.data, (int)colorImage.elemSize(), colorImage.cols, colorImage.rows, regionsOfInterest);
    
    if (alprResults.plates.size() > 0) {
        alpr::AlprPlateResult alprResult = alprResults.plates[0];
        
        PlateResult *plate = [PlateResult new];
        plate.plate = @(alprResult.bestPlate.characters.c_str());
        plate.confidence = alprResult.bestPlate.overall_confidence;
        
        plate.rows = colorImage.rows;
        plate.cols = colorImage.cols;
        
        NSMutableArray *pointsArr = [NSMutableArray array];
        for (int j = 0; j < 4; j++) {
            [pointsArr addObject:[NSValue valueWithCGPoint:CGPointMake(alprResult.plate_points[j].x, alprResult.plate_points[j].y)]];
        }
        plate.points = pointsArr;
        
        // NSLog(@"\n\n\ncols: %d\nrows: %d\npoint0.x: %d\npoint0.y: %d", colorImage.cols, colorImage.rows, alprResult.plate_points[0].x,
        //   alprResult.plate_points[0].y);

        success(plate);
    } else {
        success(nil);
    }
    
    
}

@end
