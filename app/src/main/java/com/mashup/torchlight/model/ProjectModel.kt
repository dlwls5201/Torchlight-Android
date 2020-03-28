package com.mashup.torchlight.model

data class ProjectModel(
    var required_passion:String = "LOW",
    var platform_type:String = "AOS",
    var category_ids:String = "1,5,8",
    var scale:String = "MEDIUM",
    var start_date:String = "2019-11-11",
    var joined_designers:Int = 1,
    var joined_backend_developers:Int = 1,
    var joined_client_developers:Int = 1,
    var joined_planners:Int = 1,
    var required_designers:Int = 3,
    var required_backend_developers:Int = 3,
    var required_client_developers:Int = 3,
    var required_planners:Int = 3,
    var area:String = "서울 강남역",
    var summary:String = "한줄설",
    var inquire_phone_number:String = "010-1111-2222",
    var inquire_email:String = "torch@gmail.com",
    var inquire_kakao_talk:String = "torch",

    val platformType: PlatformType = PlatformType.ANDROID,
    val name: String = "",
    val description: String= "",
    var tag: List<String> = listOf(),
    val recruitmentCnt: Int=0
)
{
    constructor(
         name: String,
         description: String,
         tag: List<String>,
         recruitmentCnt: Int
    ) : this( required_passion = "LOW",
        platform_type = "AOS",
        category_ids = "1,5,8",
        scale = "MEDIUM",
        start_date = "2019-11-11",
        joined_designers = 1,
        joined_backend_developers = 1,
        joined_client_developers = 1,
        joined_planners = 1,
        required_designers = 3,
        required_backend_developers = 3,
        required_client_developers = 3,
        required_planners = 3,
        area = "서울 강남역",
        summary = "한줄설",
        inquire_phone_number = "010-1111-2222",
        inquire_email = "torch@gmail.com",
        inquire_kakao_talk = "torch",
        platformType = PlatformType.ANDROID,
        name=name,
        description=description,
        tag=tag,
        recruitmentCnt=recruitmentCnt
        )
}

enum class PlatformType {
    ANDROID, IOS, BACKEND, WEB
}
