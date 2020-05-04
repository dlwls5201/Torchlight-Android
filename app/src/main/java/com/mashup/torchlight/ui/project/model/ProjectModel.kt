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

        fun addJoinedMember(member: Member): Member {
            val mJoinedMember = joinedMember + 1
            val mRequiredMember = if (requiredMember - mJoinedMember < 0) {
                requiredMember + 1
            } else {
                requiredMember
            }
            return when (member) {
                is PLANNER -> PLANNER(mJoinedMember, mRequiredMember)
                is CLIENT -> CLIENT(mJoinedMember, mRequiredMember)
                is SERVER -> SERVER(mJoinedMember, mRequiredMember)
                is DESIGNER -> DESIGNER(mJoinedMember, mRequiredMember)
            }
        }

        fun removeJoinedMember(member: Member): Member {
            val mJoinedMember = if (joinedMember > 0) {
                joinedMember - 1
            } else {
                joinedMember
            }

            return when (member) {
                is PLANNER -> PLANNER(mJoinedMember, requiredMember)
                is CLIENT -> CLIENT(mJoinedMember, requiredMember)
                is SERVER -> SERVER(mJoinedMember, requiredMember)
                is DESIGNER -> DESIGNER(mJoinedMember, requiredMember)
            }
        }

        fun addRequiredMember(member: Member): Member {
            val mRequiredMember = requiredMember + 1
            return when (member) {
                is PLANNER -> PLANNER(joinedMember, mRequiredMember)
                is CLIENT -> CLIENT(joinedMember, mRequiredMember)
                is SERVER -> SERVER(joinedMember, mRequiredMember)
                is DESIGNER -> DESIGNER(joinedMember, mRequiredMember)
            }
        }

        fun removeRequiredMember(member: Member): Member {
            val mRequiredMember = if (requiredMember > 1) {
                requiredMember - 1
            } else {
                requiredMember
            }

            val mJoinedMember = if (mRequiredMember - joinedMember < 1) {
                joinedMember - 1
            } else {
                joinedMember
            }

            return when (member) {
                is PLANNER -> PLANNER(mJoinedMember, mRequiredMember)
                is CLIENT -> CLIENT(mJoinedMember, mRequiredMember)
                is SERVER -> SERVER(mJoinedMember, mRequiredMember)
                is DESIGNER -> DESIGNER(mJoinedMember, mRequiredMember)
            }
        }
    }
}



