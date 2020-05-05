package com.mashup.data.mockrepositoryImpl

import com.mashup.data.composeDomain
import com.mashup.domain.data.Category
import com.mashup.domain.entity.ProjectEntity
import com.mashup.domain.repository.ProjectRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MockProjectRepoImpl : ProjectRepository {

    companion object {
        val testSample = mutableListOf(
            ProjectEntity(
                passion = ProjectEntity.Passion.ONE,
                platform = ProjectEntity.PlatformType.ANDROID,
                desktop = ProjectEntity.DesktopType.MACOS,
                field = ProjectEntity.FieldType.AI,
                categories = listOf(
                    Category.getItems()[0],
                    Category.getItems()[1],
                    Category.getItems()[2]
                ),
                scale = ProjectEntity.ProjectScale.BIG,
                planer = ProjectEntity.MemberEntity.PLANNER(1, 3),
                client = ProjectEntity.MemberEntity.CLIENT(1, 3),
                server = ProjectEntity.MemberEntity.SERVER(1, 3),
                designer = ProjectEntity.MemberEntity.DESIGNER(2, 3),
                area = "동작구",
                title = "Torchlight 안드로이드",
                summary = "안드로이드 개발을 해봐요",
                description = "있으며, 어디 심장의 같으며, 군영과 피부가 있는 황금시대다. 내는 보배를 낙원을 인간이 부패뿐이다. 능히 오아이스도 목숨을 동산에는 할지라도 그들의 아름다우냐? 남는 따뜻한 이는 무한한 속에서 것이다. 전인 장식하는 그러므로 하여도 끝까지 사막이다. 심장의 옷을 발휘하기 노래하며 청춘은 이것이다. 사랑의 이것은 가는 못할 사라지지 인류의 어디 오직 놀이 말이다. ",
                phone = "01077255201"
            ),
            ProjectEntity(
                passion = ProjectEntity.Passion.TWO,
                platform = ProjectEntity.PlatformType.IOS,
                desktop = ProjectEntity.DesktopType.LiNUX,
                field = ProjectEntity.FieldType.BLOCKCHAIN,
                categories = listOf(
                    Category.getItems()[3],
                    Category.getItems()[4]
                ),
                scale = ProjectEntity.ProjectScale.BIG,
                planer = ProjectEntity.MemberEntity.PLANNER(0, 3),
                client = ProjectEntity.MemberEntity.CLIENT(0, 3),
                area = "동작구",
                title = "Torchlight 안드로이드와 IOS",
                summary = "사이드 프로젝트 모집 플랫폼 Torchlight의\n" +
                        "iOS 앱 개발을 위한 프로젝트입니다.",
                description = "있으며, 어디 심장의 같으며, 군영과 피부가 있는 황금시대다. 내는 보배를 낙원을 인간이 부패뿐이다. 능히 오아이스도 목숨을 동산에는 할지라도 그들의 아름다우냐? 남는 따뜻한 이는 무한한 속에서 것이다. 전인 장식하는 그러므로 하여도 끝까지 사막이다. 심장의 옷을 발휘하기 노래하며 청춘은 이것이다. 사랑의 이것은 가는 못할 사라지지 인류의 어디 오직 놀이 말이다. ",
                phone = "01077255201"
            ),
            ProjectEntity(
                passion = ProjectEntity.Passion.THREE,
                platform = ProjectEntity.PlatformType.WEB,
                desktop = ProjectEntity.DesktopType.MACOS,
                field = ProjectEntity.FieldType.GAME,
                categories = listOf(
                    Category.getItems()[6],
                    Category.getItems()[7],
                    Category.getItems()[8]
                ),
                scale = ProjectEntity.ProjectScale.BIG,
                planer = ProjectEntity.MemberEntity.PLANNER(2, 3),
                client = ProjectEntity.MemberEntity.CLIENT(2, 3),
                server = ProjectEntity.MemberEntity.SERVER(2, 3),
                designer = ProjectEntity.MemberEntity.DESIGNER(2, 3),
                area = "동작구",
                title = "웹 안드로이드",
                summary = "웹 개발을 해봐요",
                description = "있으며, 어디 심장의 같으며, 군영과 피부가 있는 황금시대다. 내는 보배를 낙원을 인간이 부패뿐이다. 능히 오아이스도 목숨을 동산에는 할지라도 그들의 아름다우냐? 남는 따뜻한 이는 무한한 속에서 것이다. 전인 장식하는 그러므로 하여도 끝까지 사막이다. 심장의 옷을 발휘하기 노래하며 청춘은 이것이다. 사랑의 이것은 가는 못할 사라지지 인류의 어디 오직 놀이 말이다. ",
                phone = "01077255201"
            )
        )
    }

    override fun getProjects(): Single<List<ProjectEntity>> {
        return Single.just(testSample.toList())
            .delay(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .composeDomain()
    }

    override fun addProject(projectEntity: ProjectEntity): Completable {
        testSample.add(0, projectEntity)
        return Completable.complete()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .composeDomain()
    }
}