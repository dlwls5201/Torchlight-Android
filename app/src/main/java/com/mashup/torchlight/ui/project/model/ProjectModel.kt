package com.mashup.torchlight.ui.project.model

import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorData

data class ProjectModel(
    val passion: Passion = Passion.ONE,
    val platform: PlatformType? = null,
    val desktop: DesktopType? = null,
    val field: FieldType? = null,
    val categories: List<ItemSelectorData> = listOf(),
    val scale: ProjectScale = ProjectScale.SMALL,
    val startDate: String = "2019.10.31 토요일",
    val planer: Member = Member.PLANNER(0, 0),
    val client: Member = Member.CLIENT(0, 0),
    val server: Member = Member.SERVER(0, 0),
    val designer: Member = Member.DESIGNER(0, 0),
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

    sealed class Member(val job: String, val joinedMember: Int, val requiredMember: Int) {
        data class PLANNER(val joined: Int, val required: Int) : Member("기획자", joined, required)
        data class CLIENT(val joined: Int, val required: Int) : Member("클라이언", joined, required)
        data class SERVER(val joined: Int, val required: Int) : Member("서버", joined, required)
        data class DESIGNER(val joined: Int, val required: Int) : Member("디자이너", joined, required)
    }
}


