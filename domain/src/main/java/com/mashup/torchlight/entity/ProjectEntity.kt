package com.mashup.torchlight.entity

data class ProjectEntity(
    val passion: Passion = Passion.ONE,
    val platform: PlatformType? = null,
    val desktop: DesktopType? = null,
    val field: FieldType? = null,
    val categories: List<String> = listOf(),
    val scale: ProjectScale = ProjectScale.SMALL,
    val startDate: String = "2019.10.31 토요일",
    val planer: MemberEntity = MemberEntity.PLANNER(0, 1),
    val client: MemberEntity = MemberEntity.CLIENT(0, 1),
    val server: MemberEntity = MemberEntity.SERVER(0, 1),
    val designer: MemberEntity = MemberEntity.DESIGNER(0, 1),
    val area: String? = null,
    val title: String = "",
    val summary: String = "",
    val description: String = "",
    val phone: String = ""
) {
    enum class Passion {
        ONE, TWO, THREE
    }

    enum class PlatformType {
        ANDROID, IOS, WEB
    }

    enum class DesktopType {
        MACOS, WINDOWS, LiNUX
    }

    enum class FieldType {
        GAME, BLOCKCHAIN, AI
    }

    enum class ProjectScale {
        SMALL, MEDIUM, BIG
    }

    sealed class MemberEntity(val joinedMember: Int, val requiredMember: Int) {
        data class PLANNER(val joined: Int, val required: Int) : MemberEntity(joined, required)
        data class CLIENT(val joined: Int, val required: Int) : MemberEntity(joined, required)
        data class SERVER(val joined: Int, val required: Int) : MemberEntity(joined, required)
        data class DESIGNER(val joined: Int, val required: Int) : MemberEntity(joined, required)
    }
}
