# Bowling Kata Exercise (TDD)

A Kotlin implementation of the bowling kata exercise, written test-first with JUnit 4.

## Context

This kata was the pairing exercise in my interview. During the session, I wrote the first three tests (`one pins`, `ten pins`, `one pins for ten rolls`) and a failing test for a spare, and I described a counter-based idea for scoring spares. After the interview, I continued the kata and finished it.

## How to run

Run `GameTest` in Android Studio, or run `./gradlew test`.

## How my approach changed

1. **Store every roll, calculate later.**
In the interview, my first idea was to track state with a counter while rolling, but I later found it hard to know which frame the current roll belongs to. Since strikes and spares need to look ahead at future rolls, I changed `roll()` to only record the pins, and `score()` to do all the calculation.

2. **A spare must be inside one frame.**
My first version checked whether the previous two rolls added up to 10. The test `ten across two frames` (2, 2, then 8) showed the problem: 2 and 8 add up to 10, but they are in different frames.

3. **A strike breaks the "two rolls per frame" assumption.**
Checking `index % 2 == 0` worked until a strike, which uses only one roll. The test `one strike then one spare` exposed this, so I changed `score()` to walk through the rolls frame by frame.

4. **Strike and spare are scored the same way.**
Both are the sum of three consecutive rolls. The only difference is how many rolls the frame uses: one for a strike, two for a spare.

5. **A game has at most ten frames.**
The `perfect game` test first returned 330, because the two bonus rolls were counted as extra frames. Scoring now stops after ten frames.

6. **`score()` should not change state.**
The frame count was first stored as a property, so calling `score()` twice gave a different result. The test `score called twice` caught this, and the count is now a local variable.