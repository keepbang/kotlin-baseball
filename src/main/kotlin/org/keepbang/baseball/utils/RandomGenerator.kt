package org.keepbang.baseball.utils

import org.keepbang.baseball.domain.Ball
import org.keepbang.baseball.domain.MAX_RANGE
import org.keepbang.util.pickNumberInRange

class RandomGenerator {
    companion object {
        fun getRandomPlayerBall(): Ball {
            val distinctNumberSet: MutableSet<Int> = LinkedHashSet()

            while(distinctNumberSet.size < MAX_RANGE) {
                distinctNumberSet.add(pickNumberInRange(1, 9))
            }

            return Ball(distinctNumberSet.toList());
        }
    }
}