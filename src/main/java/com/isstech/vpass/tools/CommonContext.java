package com.isstech.vpass.tools;

/**
 * @author wangwei<br />
 * @Description: <br/>
 * @date 2019/5/15 14:48<br/>
 * ${TAGS}
 */
public class CommonContext {
    /**
     *
     */
    public static final String IP = "10.128.184.4";// 3.1.217.121 "3.1.204.206";//"3.106.10.111";  //"3.106.11.103";//"3.1.204.226"

    /**
     *
     */
    public static final String POST = "443";

    /**
     *
     */
    public static final String DOWNLOADFILE = "d:\\download_image";

    /**
     * DATE_FORMAT
     */
    public static final String DATE_FORMAT = "yyyyMMddHHmmss";

    /**
     * Unit: Seconds
     */
    public static final Integer FILE_UPLOAD_TIME_OUT = 30000;

    /**
     * 默认连接时间
     */
    public static final Integer DEFAULT_CONNECTION_TIME_OUT = 10;

    /**
     * 默认读取时间
     */
    public static final Integer DEFAULT_READ_TIME_OUT = 180;


    public static final String USERS = "/sdk_service/rest/users";

    /**
     * 用户配置管理
     */
    public static final String USERS_CONFIGURATIONS = "/sdk_service/rest/users/configurations";

    /**
     * 用户设备
     */
    public static final String USERS_DEVICERIGHTS = "/sdk_service/rest/users/{id}/devicerights";

    /**
     * 查询指定设备组下子设备组及设备数
     */
    public static final String DEVICEGROUPS_DEVICENUMBER = "/sdk_service/rest/devicegroups/devicenumber";

    /**
     * 创建存储空间
     */
    public static final String CREATE_STORAGE_SPACE = "/sdk_service/rest/image-library/create-storage-space";

    /**
     * 查询存储空间
     */
    public static final String QUERY_STORAGE_SPACE = "/sdk_service/rest/image-library/query-storage-space?space={space}";

    /**
     * 删除存储空间
     */
    public static final String DELETE_STORAGE_SPACE = "/sdk_service/rest/image-library/delete-storage-space?space={space}";

    /**
     * 查询存储空间的表空间列表
     */
    public static final String LIST_STORAGE_SPACE = "/sdk_service/rest/image-library/list-storage-space";

    /**
     * login
     */
    public static final String MANAGEMENT_APPLICATION_LOGIN = "/sdk_service/rest/users/login/v1.1";

    /**
     * 修改用户密码
     */
    public static final String MANAGEMENT_ADMINISTRATOR_CHANGE_PASSWORD = "/sdk_service/rest/management/administrator-change-password";

    /**
     * logout
     */
    public static final String MANAGEMENT_APPLICATION_LOGOUT = "/sdk_service/rest/management/application-logout";

    /**
     * 强制用户下线
     */
    public static final String USERS_OFFLINE = "/sdk_service/rest/users/offline";

    /**
     * 获取历史登陆信息
     */
    public static final String USERS_LOGIN_HISTORY = "/sdk_service/rest/users/login-history";

    /**
     * 查询当前登录用户操作权限列表
     */
    public static final String OPERATIONS = "/sdk_service/rest/operations";

    /**
     * 新建角色
     */
    public static final String ROLES = "/sdk_service/rest/roles";

    /**
     * 用户组
     */
    public static final String USER_GROUPS = "/sdk_service/rest/usergroups";

    /**
     * 批量添加用户组
     */
    public static final String USER_GROUPS_BATH_ADD = "/sdk_service/rest/usergroups/batch_add";

    /**
     *  查询指定用户组下的子（孙）用户组列表
     *  "/sdk_service/rest/usergroups/{id}?recursive={recursive}";
     */

    /**
     * 查询系统的设备域列表及域下设备数
     */
    // public static final String  DEVICEDOMAINS_DEVICENUMBER = "/sdk_service/rest/devicedomains/devicenumber?domaincode={domaincode}&countdevicenumber={countdevicenumber}";
    public static final String DEVICEDOMAINS_DEVICENUMBER = "/sdk_service/rest/devicedomains/devicenumber?domaincode=0";

    /**
     * 查询系统消息
     */
    public static final String MANAGEMENT_GET_SYSTEM_INFO = "/sdk_service/rest/management/get-system-info/v1.1?curPage=1&pageCount=100&startTime=1507729126653&endTime=1517729126653";

    /**
     * 保活消息
     */
    public static final String MANAGEMENT_OPTIONS = "/sdk_service/rest/management/options";

    /**
     * 查询系统所有资源概要信息
     */
    public static final String GET_DETAILED_SYSTEM_INFO = "/sdk_service/rest/management/get-detailed-system-info";

    /**
     * 查询集群成员 id 列表
     */
    public static final String GET_MENBER_LIST = "/sdk_service/rest/management/get-member-list";

    /**
     * 根据 ip 查询集群成员资源信息
     */
    public static final String get_cluster_member_info = "/sdk_service/rest/management/get-cluster-member-info";

    /**
     * 创建元数据
     */
    public static final String BATCH_INSERT_DATA = "/sdk_service/rest/adaptor/batchInsertData";

    /**
     * 查询元数据
     */
    public static final String QUERY_DATA = "/sdk_service/rest/adaptor/queryData";

    /**
     * 删除元数据
     */
    public static final String BATH_DELETE_DATA = "/sdk_service/rest/adaptor/batchDeleteData";

    /**
     * 设置平台统一配置参数
     */
    public static final String MANAGEMENT_CONFIGURATIONS = "/sdk_service/rest/management/configurations/v1.3";

    /**
     * 查询平台统一配置参数
     */
    public static final String MANAGEMENT_CONFIGURATIONS_1_2 = "/sdk_service/rest/management/configurations/v1.2";

    /**
     * 指定算法类型名称查询算法信息
     */
    public static final String MANAGEMENT_LOADALGORITHM = "/sdk_service/rest/management/loadAlgorithm";

    /**
     * 算法启用停用
     */
    public static final String MANAGEMENT_CHANGEALGORITHMSTATUS = "/sdk_service/rest/management/changeAlgorithmStatus";

    /**
     * 指定算法编码查询算法信息
     */
    public static final String MANAGEMENT_GETALGORITHM = "/sdk_service/rest/management/getAlgorithm";

    /**
     * 算法编辑
     */
    public static final String MANAGEMENT_EDITALGORITHM = "/sdk_service/rest/management/editAlgorithm";

    /**
     * 数据字典查询
     */
    public static final String VIDEO_ANALYSIS_GET_DATADICTIONARY = "/sdk_service/rest/video-analysis/get-datadictionary";

    /**
     * 查询特殊名单阈值
     */
    public static final String ALGORITHMS_SPECIALTHRESHOLD = "/sdk_service/rest/algorithms/specialthreshold?type={type}";

    /**
     * 更新特殊名单阈值
     */
    public static final String ALGORITHMS_SPECIALTHRESHOLD_ID = "/sdk_service/rest/algorithms/specialthreshold/{id}";

    /**
     * 查询图像信息库上传通道
     */
    public static final String IMAGE_LIBRARY_GET_UPLOAD_URL_V1_1 = "/sdk_service/rest/image-library/get-upload-url/v1.1?name={name}&length={length}";

    /**
     *  图像信息库上传文件
     */

    /**
     * 图像信息库查询上传信息
     */
    public static final String IMAGE_LIBRARY_GET_UPLOAD_FILE_ID = "/sdk_service/rest/image-library/get-uploadinfo?uploaded-file-id={uploaded-file-id}";

    /**
     * 图像信息库发布文件
     */
    public static final String IMAGE_LIBRARY_PUBLISH_UPLOAD_FILE = "/sdk_service/rest/image-library/publish-uploaded-file/v1.1";

    /**
     * 查询图像信息库批量上传地址
     */
    public static final String IMAGE_LIBRARY_PUBLISH_GET_BATCH_UPLOAD_URL = "/sdk_service/rest/image-library/get-batch-upload-url/v1.1?type={type}";

    /**
     * 图像信息库资料删除
     */
    public static final String IMAGE_LIBRARY_DELETTE_FILE = "/sdk_service/rest/image-library/delete-file?fileId={fileId}";

    /**
     * 图像信息库查询资料
     */
    public static final String IMAGE_LIBRARY_GE_FILE_DATA = "/sdk_service/rest/image-library/get-file-metadata/v1.2?fileId={fileId}";

    /**
     * 图像信息库更新资料
     */
    public static final String IMAGE_LIBRARY_UPDATE_FILE_DATA = "/sdk_service/rest/image-library/update-filemetadata";

    /**
     * 图像信息库资料搜索
     */
    public static final String IMAGE_LIBRARY_FILE_SERCH = "/sdk_service/rest/image-library/file-search/v1.3";

    /**
     * 查询媒体文件播放地址
     */
    public static final String IMAGE_LIBRARY_VIDEO_PLAYURL = "/sdk_service/rest/image-library/video-playurl?file_id={file_id}";

    /**
     * 图像信息库资料查询图片流-存在
     */
//    public static final String IMAGE_LIBRARY_GET_IMAGE = "/sdk_service/rest/image-library/get-image? fileId={fileId}&imageType={imageType}&imageSize={imageSize }";

    /**
     * 图像信息库批量资料删除
     */
    public static final String IMAGE_LIBRARY_DELETE_FILE = "/sdk_service/rest/image-library/delete-files";

    /**
     * 图像信息库查询下载通道
     */
    public static final String IMAGE_LIBRARY_GET_DOWNLOAD_URL = "/sdk_service/rest/image-library/get-download-url?casefile-id={casefileid}&type={type}";

    /**
     * 图像信息库查询目录列表
     */
    public static final String IMAGE_LIBRARY_GET_DIRECTORY_LIST = "/sdk_service/rest/image-library/get-directory-list?path={path}&recursive={recursive}&source-system-id={sourcesystem-id}";

    /**
     * 图像信息库增加目录
     */
    public static final String IMAGE_LIBRARY_ADD_DIRECTORY = "/sdk_service/rest/image-library/add-directory?source-system-id={source-system-id}";

    /**
     * 图像信息库修改目录
     */
    public static final String IMAGE_LIBRARY_UPDATE_DIRECTORY_NAME = "/sdk_service/rest/image-library/update-directory-name?source-system-id={source-system-id}";

    /**
     * 删除联网采集策略
     */
    public static final String IMAGE_LIBRARY_DELETE_DOWNLOAD_POLICY = "/sdk_service/rest/image-library/delete-download_policy?downloadpolicy-id={downloadpolicy-id}";

    /**
     * 图像信息库删除目录
     */
    public static final String IMAGE_LIBRARY_DELETE_DIRECTORY = "/sdk_service/rest/image-library/delete-directory";

    /**
     * 指定 ID 查询联网采集策略
     */
    public static final String IMAGE_LIBRARY_GET_DOWNLOAD_STATUS = "/sdk_service/rest/image-library/get-download-status?downloadpolicy-id={downloadpolicyid}";

    /**
     * 指定条件查询联网采集策略列表
     */
    public static final String IMAGE_LIBRARY_SEARCH_DOWNLOADPOLICY_V1_2 = "/sdk_service/rest/image-library/search-download-policy/v1.2";

    /**
     * 查询采集任务列表
     */
    public static final String IMAGE_LIBRARY_GET_DOWNLOAD_TASK_V1_1 = "/sdk_service/rest/image-library/get-download-task/v1.1";

    /**
     * 重试采集任务
     */
    public static final String IMAGE_LIBRARY_RESTART_DOWNLOAD_TASK = "/sdk_service/rest/image-library/restart-download-task?taskid={taskid}&downloadpolicy-id={downloadpolicy-id}";

    /**
     * 启动视频转码
     */
    public static final String IMAGE_LIBRARY_START_TRANSCODE = "/sdk_service/rest/image-library/start-transcode?file_id={file_id}";

    /**
     * 查询视频转码状态
     */
    public static final String IMAGE_LIBRARY_TRANSCODE_STATUS = "/sdk_service/rest/image-library/transcode-status?file_id={file_id}";

    /**
     * 视频时间校准
     */
    public static final String IMAGE_LIBRARY_ADJUST_TIMESTAMP = "/sdk_service/rest/image-library/adjust_timestamp/v1.1";

    /**
     * 指定视频文件 id 获取摘要信息
     */
    public static final String VIDEO_ANALYSIS_QUERYVIDEOFRAGMENT = "/sdk_service/rest/video-analysis/queryVideoFragment/v1.1?casefileId={casefileId}";

    /**
     * 视频预处理重试
     */
    public static final String IMAGE_LIBRARY_PREPROCESS = "/sdk_service/rest/image-library/preprocess";

    /**
     * 内部系统访问权限断言接口
     */
    public static final String MANAGEMENT_AUTHENTICATE_ASSERTION = "/sdk_service/rest/management/authenticate/assertion";

    /**
     * 静态库
     */
    public static final String STATICLIBRARIES = "/sdk_service/rest/staticlibraries";

    /**
     * 静态库查询人员信息
     */
    public static final String STATICLIBRARIES_PEOPLES = "/sdk_service/rest/staticlibraries/peoples";

    /**
     * 静态库添加人员信息同步接口
     */
    public static final String STATICLIBRARIES_PEOPLES_01 = "/sdk_service/rest/staticlibraries/{libraryid}/peoples";

    /**
     * 静态库删除人员信息
     */
    public static final String STATICLIBRARIES_DELETE_PEOPLES = "/sdk_service/rest/staticlibraries/{libraryid}/peoples?ids={ids}";

    /**
     * 修改静态库人员信息
     */
    public static final String STATICLIBRARIES_EDIT_PEOPLES = "/sdk_service/rest/staticlibraries/{libraryid}/peoples/{id}";

    /**
     * 创建智能分析任务
     */
    public static final String VIDEO_ANALYSIS_START_INTELLIGENT_ANALYSIS = "/sdk_service/rest/video-analysis/start-intelligent-analysis/v1.1";

    /**
     * 批量创建智能分析任务
     */
    public static final String VIDEO_ANALYSIS_TASKS = "/sdk_service/rest/video-analysis/tasks";

    /**
     * 查询智能分析任务状态
     */
    public static final String VIDEO_ANALYSIS_GET_STATUS = "/sdk_service/rest/video-analysis/get-status";

    /**
     * 查询智能分析任务列表
     */
    public static final String VIDEO_ANALYSIS_GET_INTELLIGENT_ANALYSIS_LIST = "/sdk_service/rest/video-analysis/get_intelligent_analysis_list";

    /**
     * 获取智能分析任务统计信息
     */
    public static final String VIDEO_ANALYSIS_GET_TASK_COUNT = "/sdk_service/rest/video-analysis/get_task_count?createUser={createUser}";

    /**
     * 根据任务编码查询文件信息
     */
    public static final String VIDEO_ANALYSIS_GET_FILEID_BY_TASKID = "/sdk_service/rest/video-analysis/get-fileid-by-taskid?taskId={taskid}";

    /**
     * 获取子任务进度列表
     */
    public static final String VIDEO_ANALYSIS_GET_CHILD_TASK_PROGRESS = "/sdk_service/rest/video-analysis/get-child-task-progress?taskId={taskid}&analysisId={analysisId}";

    /**
     * 指定任务编码删除智能分析任务
     */
    public static final String VIDEO_ANALYSIS_DELETE_INTELLIGENT_ANALYSIS = "/sdk_service/rest/video-analysis/delete_intelligent_analysis?taskId={taskId}";

    /**
     * 重启智能分析任务
     */
    public static final String VIDEO_ANALYSIS_RESTART_INTELLIGENT_ANALYSIS = "/sdk_service/rest/video-analysis/restart_intelligent_analysis?taskId={taskId}";

    /**
     * 根据任务编码停止智能分析任务
     */
    public static final String VIDEO_ANALYSIS_STOP_INTELLIGENT_BY_TASKID = "/sdk_service/rest/video-analysis/stop_intelligent_by_taskid?taskid={taskid}";

    /**
     * 查询黑名单
     */
    public static final String VIDEO_ANALYSIS_SEARCH_BWDATA = "/sdk_service/rest/video-analysis/search-bwdata";

    /**
     * 增加黑白名单
     */
    public static final String VIDEO_ANALYSIS_ADD_BWDATA = "/sdk_service/rest/video-analysis/add-bwdata";

    /**
     * 黑白名单组查询
     */
    public static final String VIDEO_ANALYSIS_SEARCH_BWGROUP = "/sdk_service/rest/video-analysis/search-bwgroup";

    /**
     * 黑白名单组增加
     */
    public static final String VIDEO_ANALYSIS_ADD_BWGROUP = "/sdk_service/rest/video-analysis/add-bwgroup";

    /**
     * 黑白名单组删除
     */
    public static final String VIDEO_ANALYSIS_DELETE_BWGROUP = "/sdk_service/rest/video-analysis/delete-bwgroup";

    /**
     * 查询卡口列表
     */
    public static final String BAYONET_QUERY = "/sdk_service/rest/bayonet/query";

    /**
     * 指定卡口查询摄像机列表
     */
    public static final String BAYONET_QUERY_CAMERAS = "/sdk_service/rest/bayonet/query-cameras";

    /**
     * 指定卡口增加摄像机
     */
    public static final String BAYONET_ADD_CAMERAS = "/sdk_service/rest/bayonet/add-camera";

    /**
     * 获取摄像机列表
     */
    public static final String CAMERAS_V_1_1 = "/sdk_service/rest/cameras/v1.1";

    /**
     * 指定卡口删除摄像机
     */
    public static final String BAYONET_DEL_CAMERAS = "/sdk_service/rest/bayonet/del-camera";

    /**
     * 同步摄像机
     */
    public static final String VIDEO_ANALYSIS_SYNC_CAMERA = "/sdk_service/rest/video-analysis/sync-camera";

    /**
     * 实时订阅/取消订阅智能摄像机数据 Subscribing to or Unsubscribing from Intelligent Real-Time Camera Data
     */
    public static final String VIDEO_ANALYSIS_SUBSCRIBE_CAMERA_DATA = "/sdk_service/rest/video-analysis/subscribe-camera-data";

    /**
     * 获取 ticket
     */
    public static final String VIDEO_ANALYSIS_GET_TICKET = "/sdk_service/rest/video-analysis/get-ticket";

    /**
     * 批量修改摄像机虚拟属性 Modifying Camera Virtual Attributes in Batch
     */
    public static final String VIDEO_ANALYSIS_EDIT_CAMERA_FEATURE = "/sdk_service/rest/video-analysis/edit-camera-feature";

    /**
     * 设置摄像机区域标签 Configuring Camera Area Tags
     */
    public static final String CAMERAS_AREATAGS = "/sdk_service/rest/cameras/areatags";

    /**
     * 根据区域标签查询摄像机
     */
    public static final String CAMERAS_AREATAGS_V1_1 = "/sdk_service/rest/cameras/v1.1?tags={tags}&logic={logic}&no={no}&size={size}";
    /**
     * 人脸比对 1:1
     */
    public static final String FACEMATCH_1V1 = "/sdk_service/rest/facematch/1v1";

    /**
     * 人脸对比 NVN
     */
    public static final String FACEMATCH_NVN_1 = "/sdk_service/rest/facematch/nvn";

    /**
     * 过人过脸搜索
     */
    public static final String VIDEOANALYSIS_PEOPLEFACES_V1_5 = "/sdk_service/rest/videoanalysis/peoplefaces/v1.5";

    /**
     * 获取人脸对比 NVN 数据
     */
    public static final String FACEMATCH_NVN = "/sdk_service/rest/facematch/nvn?taskId={taskId}";

    /**
     * Querying the Upload Channel of the Image Information Library
     */
    public static final String IMAGE_LIBRARY_GET_UPLOAD_URL = "/sdk_service/rest/image-library/get-upload-url";

    /**
     * 更新黑白名单
     */
    public static final String VIDEO_ANALYSIS_UPDATE_BWDATA = "/sdk_service/rest/video-analysis/update-bwdata";

    /**
     * 增加布控任务 Adding an Alert Deployment Task
     */
    public static final String VIDEO_ANALYSIS_ADD_SUSPECT_TASK_V1_1 = "/sdk_service/rest/video-analysis/add-suspect-task/v1.1";

    /**
     * 编辑布控任务
     */
    public static final String VIDEO_ANALYSIS_EDIT_SUSPECT_TASK_V1_1 = "/sdk_service/rest/video-analysis/edit-suspect-task/v1.1";

    /**
     * 启用与停用布控任务
     */
    public static final String VIDEO_ANALYSIS_ENABLE_SUSPECT_TASK = "/sdk_service/rest/video-analysis/enable-suspect-task";

    /**
     * 查询布控任务
     */
    public static final String VIDEO_ANALYSIS_SEARCH_SUSPECT_TASK_V1_1 = "/sdk_service/rest/video-analysis/search-suspect-task/v1.1";

    /**
     * 删除布控任务
     */
    public static final String VIDEO_ANALYSIS_DELETE_SUSPECT_TASK = "/sdk_service/rest/video-analysis/delete-suspect-task";

    /**
     * 布控任务添加卡口
     */
    public static final String VIDEO_ANALYSIS_EDIT_SUSPECT_TASK_ADD_BAYONET = "/sdk_service/rest/video-analysis/edit-suspect-task-add-bayonet";

    /**
     * 布控任务删除卡口
     */
    public static final String VIDEO_ANALYSIS_EDIT_SUSPECT_TASK_DELETE_BAYONET = "/sdk_service/rest/video-analysis/edit-suspect-task-delete-bayonet";

    /**
     * 实时过车统计
     */
    public static final String STATISTICANALYSIS_PLATE_TODY = "/sdk_service/rest/statisticanalysis/plate/today";

    /**
     * 历史过车统计
     */
    public static final String STATISTICANALYSIS_PLATE_HISTORY = "/sdk_service/rest/statisticanalysis/plate/history";

    /**
     * 实时过脸统计
     */
    public static final String STATISTICANALYSIS_FACE_TODY = "/sdk_service/rest/statisticanalysis/plate/today";

    /**
     * 实时过脸统计
     */
    public static final String STATISTICANALYSIS_FACE_HISTORY = "/sdk_service/rest/statisticanalysis/face/history";

    /**
     * 人数统计
     */
    public static final String STATISTICANALYSIS_PEOPLE = "/sdk_service/rest/statisticanalysis/people";

    /**
     * 增加或修改联网采集策略 Adding or Modifying a Networking Collection Policy
     */
    public static final String IMAGE_LIBRARY_ADD_DOWNLOAD_POLICY_V1_1 = "/sdk_service/rest/image-library/add-download-policy/v1.1";

    /**
     * Creating Intelligent Analysis Task
     */
//    public static final String VIDEO_ANALYSIS_TASKS = "/sdk_service/rest/video-analysis/tasks";

    /**
     * Subscribing to Data and Obtaining the Connection
     */
    public static final String VIDEO_ANALYSIS_SUBSCRIPTION = "/sdk_service/rest/video-analysis/subscription";

    /**
     * Obtain historical vehicle metadata.
     */
    public static final String VIDEO_ANALYSIS_SEARCH_VEHICLE_V1_2 = "/sdk_service/rest/video-analysis/search-vehicle/v1.2";

    /**
     * Obtain historical vehicle metadata.
     */
    public static final String VIDEO_ANALYSIS_SEARCH_VEHICLE_V1_1 = "/sdk_service/rest/video-analysis/search-vehicle/v1.1";

    /**
     * Download Image
     */
    public static final String IMAGE_LIBRARY_GET_IMAGE = "/sdk_service/rest/image-library/get-image";

    /**
     * Downloading Human Body or Facial Images 下载人体人脸图片
     */
    public static final String VIDEOANALYSIS_PEOPLEFACE_IMAGE = "/sdk_service/rest/videoanalysis/peopleface/image";

    /**
     * Creating an Intelligent Analysis Task
     */
    public static final String VIDEO_ANALYSIS_START_INTELLIGENT_ANALYSIS_V1_1 = "/sdk_service/rest/video-analysis/start-intelligent-analysis/v1.1";

    /**
     * Obtaining Alarm Information Channels
     */
    public static final String VIDEO_ANALYSIS_GET_ALARM_URL = "/sdk_service/rest/video-analysis/get-alarm-url";

    /**
     * Subscribing to or Unsubscribing From Alarms
     */
    public static final String VIDEO_ANALYSIS_SUBSCRIBE_ALARM = "/sdk_service/rest/video-analysis/subscribe-alarm?task-id={task-id}&flag={flag}";


    /**
     * Searching for Vehicles Based on Images
     */
    public static final String IMAGEANALYSIS_VEHICLES_V1_1 = "/sdk_service/rest/imageanalysis/vehicles/v1.1";

    /**
     * Querying File Information Based on Specific Conditions in the Image Information Library
     */
    public static final String IMAGE_LIBRARY_FILE_SEARCH_V1_1 = "/sdk_service/rest/image-library/file-search/v1.1";

    /**
     * Querying File Information Based on Specific Conditions in the Image Information Library
     */
    public static final String IMAGE_LIBRARY_FILE_SEARCH_V1_2 = "/sdk_service/rest/image-library/file-search/v1.2";

    /**
     * Querying a Collection Task List
     */
//    public static final String IMAGE_LIBRARY_GET_DOWNLOAD_TASK_V1_1 = "/sdk_service/rest/image-library/get-download-task/v1.1";

    /**
     * Querying Historical Alarms
     */
    public static final String VIDEO_ANALYSIS_SEARCH_ALARM_V1_1 = "/sdk_service/rest/video-analysis/search-alarm/v1.1";

    /**
     * Querying Historical Alarms v1.2
     */
    public static final String VIDEO_ANALYSIS_SEARCH_ALARM_V1_2 = "/sdk_service/rest/video-analysis/search-alarm/v1.2";

    /**
     * Obtaining the Camera List
     */
    public static final String CAMERAS_V1_1 = "/sdk_service/rest/cameras/v1.1";

    /**
     * Adding a Checkpoint
     */
    public static final String BAYONET_ADD = "/sdk_service/rest/bayonet/add";

    /**
     * Adding Cameras for Specified Checkpoints
     */
    public static final String BAYONET_ADD_CAMERA = "/sdk_service/rest/bayonet/add-camera";

    /**
     * Querying the Upload Channel of the Image Information Library
     */
//    public static final String IMAGE_LIBRARY_GET_UPLOAD_URL = "/sdk_service/rest/image-library/get-upload-url";

    /**
     * push file
     */
    public static final String IMAGE_LIBRARY_PUBLISH_UPLOADED_FILE_V1_1 = "/sdk_service/rest/image-library/publish-uploaded-file/v1.1";


    /**
     * Searching for Passing Persons and Faces
     */
    public static final String VIDEOANALYSIS_PEOPLEFACES_V1_1 = "/sdk_service/rest/videoanalysis/peoplefaces/v1.1";

    /**
     * Searching for Passing Faces
     */
    public static final String VIDEOANALYSIS_PEOPLEFACES_V1_2 = "/sdk_service/rest/videoanalysis/peoplefaces/v1.2";

    /**
     * Adding a Face Image Library
     */
    public static final String FACEREPOSITORIES = "/sdk_service/rest/facerepositories";

    /**
     * Adding a Person to a List Based on Specified Images Asynchronously
     */
    public static final String FACEREPOSITORIES_REPOSITORID_PEOPLES = "/sdk_service/rest/facerepositories/{repositorid}/peoples";

    /**
     * Adding a Static Library
     */
//    public static final String STATICLIBRARIES = "/sdk_service/rest/staticlibraries";

    /**
     * Adding Personnel Information to the Static Library
     */
    public static final String STATICLIBRARIES_LIBRARYID_PEOPLES = "/sdk_service/rest/staticlibraries/{libraryid}/peoples";

    /**
     * Querying Personnel Information in the Static Library
     */
//    public static final String STATICLIBRARIES_PEOPLES = "/sdk_service/rest/staticlibraries/peoples";

    /**
     * Matching Faces in One-to-One Mode
     */
//    public static final String FACEMATCH_1V1 = "/sdk_service/rest/facematch/1v1";

    /**
     * Querying the Batch Upload Address in the Image Information Library
     */
    public static final String IMAGE_LIBRARY_GET_BATCH_UPLOAD_URL = "/sdk_service/rest/image-library/get-batch-upload-url";

    /**
     * Obtaining Synopsis Information Based on a Specific Video File ID
     */
//    public static final String VIDEO_ANALYSIS_QUERYVIDEOFRAGMENT = "/sdk_service/rest/video-analysis/queryVideoFragment?casefileId={casefileId}";

    /**
     * search for people, vehicles, and other tracks in a specified video
     */
    public static final String VIDEO_ANALYSIS_TASK_SEARCH = "/sdk_service/rest/video-analysis/task-search?file-id={file-id}&object-type={object-type}&page-size={page-size}&page-no={page-no}";

    /**
     * obtain the video snapshot file stream based on a specified time point.
     */
    public static final String IMAGE_LIBRARY_VIDEO_SNAPSHOT = "/sdk_service/rest/image-library/video-snapshot?file_id={file_id}&timestamp={timestamp}";

    /**
     * Starting Video Transcoding
     */
//    public static final String IMAGE_LIBRARY_START_TRANSCODE = "/sdk_service/rest/image-library/start-transcode?file_id={file_id}";

    /**
     * Querying the Video Transcoding Status
     */
//    public static final String IMAGE_LIBRARY_TRANSCODE_STATUS = "/sdk_service/rest/image-library/transcode-status?file_id={file_id}";

    /**
     * Obtaining the Video Clipping File Based on a Specified Time Segment
     */
    public static final String IMAGE_LIBRARY_VIDEO_CLIP_V1_1 = "/sdk_service/rest/image-library/video-clip/v1.1?file_id={file_id}&start_frame={start_frame}&end_frame={end_frame}";

    /**
     * Searching for a Scene (Obtaining Image with Tracks)
     */
    public static final String VIDEO_ANALYSIS_SCENE_SEARCH = "/sdk_service/rest/video-analysis/scene-search";

    /**
     * Searching for a Scene (Obtaining Track Data)
     */
    public static final String VIDEO_ANALYSIS_SCENE_SEARCH_STRONG = "/sdk_service/rest/video-analysis/scene-search-strong";

    /**
     * Querying the Original Track Data of a Track Objective
     */
    public static final String VIDEO_ANALYSIS_GET_MARK_TRACK = "/sdk_service/rest/video-analysis/get-mark-track";

    /**
     * recording
     */
    public static final String HISTORY_RECORD = "1";

    /**
     * live
     */
    public static final String ANALYSIS_TASK_LIVE = "0";
}
