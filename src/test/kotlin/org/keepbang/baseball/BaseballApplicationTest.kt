package org.keepbang.baseball

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.keepbang.org.keepbang.baseball.main
import org.keepbang.util.Randoms
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.MockedStatic.Verification
import org.mockito.Mockito.mockStatic


class BaseballApplicationTest : NSTest() {
    @BeforeEach
    fun beforeEach() {
        super.setUp()
    }

    @Test
    fun 낫싱() {
        mockStatic(Randoms::class.java).use { mockRandoms ->
            mockRandoms
                .`when`<Any>(Verification {
                    Randoms.pickNumberInRange(
                        anyInt(),
                        anyInt()
                    )
                })
                .thenReturn(1, 3, 5)
            running("246")
            verify("낫싱")
        }
    }

    @Test
    fun 게임종료_후_재시작() {
        mockStatic(Randoms::class.java).use { mockRandoms ->
            mockRandoms.`when`<Any>(Verification {
                Randoms.pickNumberInRange(
                    anyInt(),
                    anyInt()
                )
            })
                .thenReturn(7, 1, 3)
                .thenReturn(5, 8, 9)
            run("713", "1", "597", "589", "2")
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼")
        }
    }

    @AfterEach
    fun tearDown() {
        outputStandard()
    }

    override fun runMain() {
        main()
    }
}