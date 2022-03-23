/*
 * Copyright (c) 2015 platescanner Technology, Inc.
 * Open source Automated License Plate Recognition [http://www.platescanner.com]
 *
 * This file is part of platescanner.
 *
 * platescanner is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License
 * version 3 as published by the Free Software Foundation
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/
#ifndef platescanner_CONSTANTS_H
#define platescanner_CONSTANTS_H



#define RUNTIME_DIR 		"/runtime_data"
#define CONFIG_FILE 		"/platescanner.conf"
#define KEYPOINTS_DIR		"/keypoints"
#define CASCADE_DIR		"/region/"
#define POSTPROCESS_DIR		"/postprocess"

#define DEFAULT_SHARE_DIR   INSTALL_PREFIX "/share/platescanner"

#define DEFAULT_RUNTIME_DATA_DIR 	    DEFAULT_SHARE_DIR "/runtime_data"
#define CONFIG_FILE_TEMPLATE_LOCATION 	DEFAULT_SHARE_DIR "/config/platescanner.defaults.conf"

#ifndef DEFAULT_CONFIG_FILE
  #define DEFAULT_CONFIG_FILE 	"/etc/platescanner/platescanner.conf"
#endif

#define ENV_VARIABLE_CONFIG_FILE "platescanner_CONFIG_FILE"

#endif // platescanner_CONSTANTS_H