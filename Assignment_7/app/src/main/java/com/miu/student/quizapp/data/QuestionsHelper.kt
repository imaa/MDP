package com.miu.student.quizapp.data

import android.os.AsyncTask
import com.miu.student.quizapp.QuizApp
import com.miu.student.quizapp.data.domain.Answer
import com.miu.student.quizapp.data.domain.Question

class QuestionsHelper {
    companion object {
        fun initQuestions() {
            val questions = mutableListOf(
                Question(
                    text = "What is the base class for all Android activities?",
                    answers = listOf(
                        Answer(text = "Activity", isCorrect = true, id = 1),
                        Answer(text = "Application", isCorrect = false, id = 2),
                        Answer(text = "Service", isCorrect = false, id = 3),
                        Answer(text = "Intent", isCorrect = false, id = 4)
                    )
                ),
                Question(
                    text = "Which of the following is NOT a valid Android component?",
                    answers = listOf(
                        Answer(text = "Activity", isCorrect = false, id = 5),
                        Answer(text = "Service", isCorrect = false  , id = 6),
                        Answer(text = "Broadcast Receiver", isCorrect = false   , id = 7),
                        Answer(text = "Widget", isCorrect = true    , id = 8)
                    )
                ),
                Question(
                    text = "Which of the following is NOT a valid Android resource type?",
                    answers = listOf(
                        Answer(text = "drawable", isCorrect = false, id = 9),
                        Answer(text = "layout", isCorrect = false, id = 10),
                        Answer(text = "string", isCorrect = false, id = 11),
                        Answer(text = "color", isCorrect = false,   id = 12),
                        Answer(text = "font", isCorrect = true,  id = 13)
                    )
                ),
                Question(
                    text = "What is the name of the file that contains the AndroidManifest.xml?",
                    answers = listOf(
                        Answer(text = "manifest.xml", isCorrect = true, id = 14),
                        Answer(text = "android.xml", isCorrect = false, id = 15),
                        Answer(text = "app.xml", isCorrect = false, id = 16),
                        Answer(text = "build.gradle", isCorrect = false, id = 17)
                    )
                ),
                Question(
                    text = "Which of the following is NOT a valid Android build variant?",
                    answers = listOf(
                        Answer(text = "debug", isCorrect = false, id = 18),
                        Answer(text = "release", isCorrect = false, id = 19),
                        Answer(text = "beta", isCorrect = false, id = 20),
                        Answer(text = "alpha", isCorrect = false, id = 21),
                        Answer(text = "custom", isCorrect = true, id = 22)
                    )
                ),
                Question(
                    text = "Which of the following is NOT a valid Android view type?",
                    answers = listOf(
                        Answer(text = "TextView", isCorrect = false, id = 23),
                        Answer(text = "Button", isCorrect = false, id = 24),
                        Answer(text = "ImageView", isCorrect = false, id = 25),
                        Answer(text = "LinearLayout", isCorrect = false, id = 26),
                        Answer(text = "Table", isCorrect = true, id = 27)
                    )
                ),
                Question(
                    text = "What is Android Room used for?",
                    answers = listOf(
                        Answer(
                            text = "Storing and managing data in a SQLite database",
                            isCorrect = true,
                            id = 28
                        ),
                        Answer(text = "Creating user interfaces", isCorrect = false, id = 29),
                        Answer(text = "Handling network requests", isCorrect = false,   id = 30),
                        Answer(text = "Managing device sensors and hardware", isCorrect = false, id = 31)
                    )
                ),
                Question(
                    text = "Which of the following is NOT a part of Android Room?",
                    answers = listOf(
                        Answer(text = "Entity class", isCorrect = false, id = 32),
                        Answer(text = "DAO (Data Access Object)", isCorrect = false, id = 33),
                        Answer(text = "Database class", isCorrect = false, id = 34),
                        Answer(text = "Content provider", isCorrect = true, id = 35)
                    )
                ),
                Question(
                    text = "What is a DAO in Android Room?",
                    answers = listOf(
                        Answer(
                            text = "A class that represents a database table",
                            isCorrect = false,
                            id = 36
                        ),
                        Answer(
                            text = "A class that defines database queries and updates",
                            isCorrect = true,
                            id = 37
                        ),
                        Answer(
                            text = "A class that manages database transactions",
                            isCorrect = false,
                            id = 38
                        ),
                        Answer(
                            text = "A class that generates SQLite statements automatically",
                            isCorrect = false,
                            id = 39
                        )
                    )
                ),
                Question(
                    text = "Which of the following is NOT a part of the Android Room library?",
                    answers = listOf(
                        Answer(text = "Entity class", isCorrect = false,    id = 40),
                        Answer(text = "DAO (Data Access Object)", isCorrect = false, id = 41),
                        Answer(text = "Database class", isCorrect = false, id = 42),
                        Answer(text = "LiveData", isCorrect = true, id = 43)
                    )
                ),
                Question(
                    text = "Which of the following is a benefit of using Android Room?",
                    answers = listOf(
                        Answer(
                            text = "It simplifies database access and management",
                            isCorrect = true,
                            id = 44
                        ),
                        Answer(
                            text = "It provides a more powerful and flexible database engine",
                            isCorrect = false,
                            id = 45
                        ),
                        Answer(
                            text = "It allows for offline data storage and synchronization",
                            isCorrect = false,
                            id = 46
                        ),
                        Answer(
                            text = "It integrates seamlessly with other Android libraries and frameworks",
                            isCorrect = false,
                            id = 47
                        )
                    )
                ),
                Question(
                    text = "Which of the following is NOT a way to retrieve data from an Android Room database?",
                    answers = listOf(
                        Answer(
                            text = "Using a SELECT statement in a DAO method",
                            isCorrect = false,
                            id = 48
                        ),
                        Answer(
                            text = "Using the `findById()` method of the `Room` class",
                            isCorrect = true,
                            id = 49
                        ),
                        Answer(
                            text = "Querying the database using a `@Query` annotated method in a DAO",
                            isCorrect = false,
                            id = 50
                        ),
                        Answer(
                            text = "Observing a LiveData object returned by a DAO method",
                            isCorrect = false,
                            id = 51
                        )
                    )
                ),
                Question(
                    text = "Which of the following is NOT a way to update data in an Android Room database?",
                    answers = listOf(
                        Answer(
                            text = "Using a `@Insert` annotated method in a DAO",
                            isCorrect = true,
                            id = 52
                        ),
                        Answer(
                            text = "Using a `@Update` annotated method in a DAO",
                            isCorrect = false,
                            id = 53
                        ),
                        Answer(
                            text = "Using a `@Delete` annotated method in a DAO",
                            isCorrect = false,
                            id = 54
                        ),
                        Answer(
                            text = "Executing a SQL UPDATE statement in a DAO method",
                            isCorrect = false,
                            id = 55
                        )
                    )
                ),
                Question(
                    text = "Which of the following is NOT a way to delete data in an Android Room database?",
                    answers = listOf(
                        Answer(
                            text = "Using a `@Delete` annotated method in a DAO",
                            isCorrect = false,
                            id = 56
                        ),
                        Answer(
                            text = "Executing a SQL DELETE statement in a DAO method",
                            isCorrect = false,
                            id = 57
                        ),
                        Answer(
                            text = "Using the `delete()` method of the `Room` class",
                            isCorrect = true,
                            id = 58
                        ),
                        Answer(
                            text = "Using a `@Query` annotated method with a DELETE statement in a DAO",
                            isCorrect = false,
                            id = 59
                        )
                    )
                ),
                Question(
                    text = "Which of the following is NOT a feature of Android Room?",
                    answers = listOf(
                        Answer(text = "Automatic database migration", isCorrect = false, id = 60),
                        Answer(
                            text = "Built-in support for reactive programming",
                            isCorrect = false,
                            id = 61
                        ),
                        Answer(text = "Compile-time checking of SQL queries", isCorrect = false, id = 62),
                        Answer(text = "Automatic memory management", isCorrect = true, id = 63)
                    )
                )
            )
            AsyncTask.execute {
                for (question in QuizApp.database.questionDao().getAll()) {
                    QuizApp.database.questionDao().delete(question)
                }
                questions.forEach(QuizApp.database.questionDao()::insert)
            }
        }
    }
}