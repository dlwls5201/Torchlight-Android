package com.mashup.torchlight.ui.project.model

import com.mashup.data.mockrepositoryImpl.MockProjectRepoImpl
import com.mashup.domain.entity.ProjectEntity
import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorData

data class ProjectModel(
    val id: Int = -1,
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
        ONE, TWO, THREE;
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

fun List<ProjectEntity>.mapToPresentation(): List<ProjectModel> =
    map { it.mapToPresentation() }

fun ProjectEntity.mapToPresentation(): ProjectModel = let {
    ProjectModel(
        id = it.id,
        passion = it.passion.mapToPresentation(),
        platform = it.platform?.mapToPresentation(),
        desktop = it.desktop?.mapToPresentation(),
        field = it.field?.mapToPresentation(),
        categories = it.categories.mapIndexed { index, category ->
            ItemSelectorData(index, category, null)
        },
        scale = it.scale.mapToPresentation(),
        startDate = it.startDate,
        planer = it.planer.mapToPresentation(),
        client = it.client.mapToPresentation(),
        server = it.server.mapToPresentation(),
        designer = it.designer.mapToPresentation(),
        area = it.area,
        title = it.title,
        summary = it.summary,
        description = it.description,
        phone = it.phone
    )
}

fun ProjectEntity.Passion.mapToPresentation() = run {
    when (this) {
        ProjectEntity.Passion.ONE -> ProjectModel.Passion.ONE
        ProjectEntity.Passion.TWO -> ProjectModel.Passion.TWO
        ProjectEntity.Passion.THREE -> ProjectModel.Passion.THREE
    }
}

fun ProjectEntity.PlatformType.mapToPresentation() = run {
    when (this) {
        ProjectEntity.PlatformType.ANDROID -> ProjectModel.PlatformType.ANDROID
        ProjectEntity.PlatformType.IOS -> ProjectModel.PlatformType.IOS
        ProjectEntity.PlatformType.WEB -> ProjectModel.PlatformType.WEB
    }
}

fun ProjectEntity.DesktopType.mapToPresentation() = run {
    when (this) {
        ProjectEntity.DesktopType.MACOS -> ProjectModel.DesktopType.MACOS
        ProjectEntity.DesktopType.WINDOWS -> ProjectModel.DesktopType.WINDOWS
        ProjectEntity.DesktopType.LiNUX -> ProjectModel.DesktopType.LiNUX
    }
}

fun ProjectEntity.FieldType.mapToPresentation() = run {
    when (this) {
        ProjectEntity.FieldType.GAME -> ProjectModel.FieldType.GAME
        ProjectEntity.FieldType.BLOCKCHAIN -> ProjectModel.FieldType.BLOCKCHAIN
        ProjectEntity.FieldType.AI -> ProjectModel.FieldType.AI
    }
}

fun ProjectEntity.ProjectScale.mapToPresentation() = run {
    when (this) {
        ProjectEntity.ProjectScale.SMALL -> ProjectModel.ProjectScale.SMALL
        ProjectEntity.ProjectScale.MEDIUM -> ProjectModel.ProjectScale.MEDIUM
        ProjectEntity.ProjectScale.BIG -> ProjectModel.ProjectScale.BIG
    }
}

fun ProjectEntity.MemberEntity.mapToPresentation() = let {
    when (it) {
        is ProjectEntity.MemberEntity.PLANNER -> ProjectModel.Member.PLANNER(
            it.joinedMember,
            it.requiredMember
        )
        is ProjectEntity.MemberEntity.CLIENT -> ProjectModel.Member.CLIENT(
            it.joinedMember,
            it.requiredMember
        )
        is ProjectEntity.MemberEntity.SERVER -> ProjectModel.Member.SERVER(
            it.joinedMember,
            it.requiredMember
        )
        is ProjectEntity.MemberEntity.DESIGNER -> ProjectModel.Member.DESIGNER(
            it.joinedMember,
            it.requiredMember
        )
    }
}

fun ProjectModel.mapToEntity() = let {
    ProjectEntity(
        id = MockProjectRepoImpl.testSample.size,
        passion = when (it.passion) {
            ProjectModel.Passion.ONE -> ProjectEntity.Passion.ONE
            ProjectModel.Passion.TWO -> ProjectEntity.Passion.TWO
            ProjectModel.Passion.THREE -> ProjectEntity.Passion.THREE
        },
        platform = when (it.platform) {
            ProjectModel.PlatformType.ANDROID -> ProjectEntity.PlatformType.ANDROID
            ProjectModel.PlatformType.IOS -> ProjectEntity.PlatformType.IOS
            ProjectModel.PlatformType.WEB -> ProjectEntity.PlatformType.WEB
            else -> null
        },
        desktop = when (it.desktop) {
            ProjectModel.DesktopType.MACOS -> ProjectEntity.DesktopType.MACOS
            ProjectModel.DesktopType.WINDOWS -> ProjectEntity.DesktopType.WINDOWS
            ProjectModel.DesktopType.LiNUX -> ProjectEntity.DesktopType.LiNUX
            else -> null
        },
        field = when (it.field) {
            ProjectModel.FieldType.GAME -> ProjectEntity.FieldType.GAME
            ProjectModel.FieldType.BLOCKCHAIN -> ProjectEntity.FieldType.BLOCKCHAIN
            ProjectModel.FieldType.AI -> ProjectEntity.FieldType.AI
            else -> null
        },
        categories = it.categories.map { it.name },
        scale = when (it.scale) {
            ProjectModel.ProjectScale.SMALL -> ProjectEntity.ProjectScale.SMALL
            ProjectModel.ProjectScale.MEDIUM -> ProjectEntity.ProjectScale.MEDIUM
            ProjectModel.ProjectScale.BIG -> ProjectEntity.ProjectScale.BIG
        },
        startDate = it.startDate,
        planer = ProjectEntity.MemberEntity.PLANNER(
            it.planer.joinedMember,
            it.planer.requiredMember
        ),
        client = ProjectEntity.MemberEntity.CLIENT(
            it.client.joinedMember,
            it.client.requiredMember
        ),
        server = ProjectEntity.MemberEntity.SERVER(
            it.server.joinedMember,
            it.server.requiredMember
        ),
        designer = ProjectEntity.MemberEntity.DESIGNER(
            it.designer.joinedMember,
            it.designer.requiredMember
        ),
        area = it.area,
        title = it.title,
        summary = it.summary,
        description = it.description,
        phone = it.phone
    )
}



