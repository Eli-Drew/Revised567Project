package com.example.elirinker.quizgame

import androidx.lifecycle.ViewModel
import com.eli.android.revised567project.R

class QuestionViewModel: ViewModel() {

    var currentIndex = 0
//    var questionBank: List<Question>? = null
    var correctAnswers : Double = 0.0


    private val cppEasyQuestionBank = listOf(
        Question(R.string.cppEasyQuestion1, R.string.cppEasyChoices1, "A", "CPP", "Easy")

    )

    private val cppMediumQuestionBank = listOf(
        Question(R.string.cppMediumQues1, R.string.cppMediumChoices1, "B", "CPP", "Medium")
    )

    private val cppHardQuestionBank = listOf(
        Question(R.string.cppHardQues1, R.string.cppHardChoices1, "C", "CPP", "Hard")
    )

    private val cppProdigyQuestionBank = listOf(
        Question(R.string.cppProdigyQues1, R.string.cppProdigyChoices1, "D", "CPP", "Prodigy")
    )

    private val cppQuestionBank = listOf(
        cppEasyQuestionBank,
        cppMediumQuestionBank,
        cppHardQuestionBank,
        cppProdigyQuestionBank
    )

    private val easyCSharpeQuestionBank = listOf(
        Question(R.string.easyCSOne, R.string.easyCSOneAns, "C", "C#", "Easy"),
        Question(R.string.easyCSTwo, R.string.easyCSTwoAns, "B", "C#", "Easy")
    )

    private val mediumCSharpeQuestionBank = listOf(
        Question(R.string.medCSOne, R.string.medCSOneAns, "A", "C#", "Medium"),
        Question(R.string.medCSTwo, R.string.medCSTwoAns, "B", "C#", "Medium")
    )

    private val hardCSharpeQuesitonBank = listOf(
        Question(R.string.hardCSOne, R.string.hardCSOneAns, "C", "C#", "Hard"),
        Question(R.string.hardCSTwo, R.string.hardCSTwoAns, "B", "C#", "Hard")
    )

    private val prodigyCSharpeQuestionBank = listOf(
        Question(R.string.prodigyCSOne, R.string.prodigyCSOneAns, "C", "C#", "Prodigy"),
        Question(R.string.prodigyCSTwo, R.string.prodigyCSTwoAns, "A", "C#", "Prodigy")
    )

    private val cSharpeQuestionBank = listOf(
        easyCSharpeQuestionBank,
        mediumCSharpeQuestionBank,
        hardCSharpeQuesitonBank,
        prodigyCSharpeQuestionBank
    )

    private val easyJsQuestionBank = listOf(
        Question(R.string.easyJSOne, R.string.easyJSOneAns, "C", "JavaScript", "Easy"),
        Question(R.string.easyJSTwo, R.string.easyCSTwoAns, "C", "JavaScript", "Easy")
    )

    private val mediumJsQuestionBank = listOf(
        Question(R.string.medJSOne, R.string.medJSOneAns, "C", "JavaScript", "Medium"),
        Question(R.string.medJSTwo, R.string.medJSTwoAns, "A", "JavaScript", "Medium")
    )

    private val hardJsQuestionBank = listOf(
        Question(R.string.hardJSOne, R.string.hardJSOneAns, "A", "JavaScript", "Hard"),
        Question(R.string.hardJSTwo, R.string.hardCSTwoAns, "B", "JavaScript", "Hard")
    )

    private val prodigyJsQuestionBank = listOf(
        Question(R.string.prodigyJSOne, R.string.prodigyJSOneAns, "C", "JavaScript", "Prodigy"),
        Question(R.string.prodigyJSTwo, R.string.prodigyJSTwoAns, "C", "JavaScript", "Prodigy")
    )

    private val jsQuestionBank = listOf(
        easyJsQuestionBank,
        mediumJsQuestionBank,
        hardJsQuestionBank,
        prodigyJsQuestionBank
    )

    private val easyPythonQuestionBank = listOf(
        Question(R.string.PythonEasyQues1, R.string.PythonEasyChoices1, "A", "Python", "Easy")
    )

    private val mediumPythonQuestionBank = listOf(
        Question(R.string.PythonMediumQues1, R.string.PythonMediumChoices, "D", "Python", "Medium")
    )

    private val hardPythonQuesitonBank = listOf(
        Question(R.string.PythonHardQues1, R.string.PythonHardChoices1, "D", "Python", "Hard")
    )

    private val prodigyPythonQuestionBank = listOf(
        Question(R.string.PythonProdigyQues1, R.string.PythonProdigyChoices1, "C", "Python", "Hard")
    )

    private val pythonQuestionBank = listOf(
        easyPythonQuestionBank,
        mediumPythonQuestionBank,
        hardPythonQuesitonBank,
        prodigyPythonQuestionBank
    )

    fun getQuestionBank(language: String, difficulty: String) : List<Question> {
        val questionBankFirst = when (language) {
            "Python" ->  pythonQuestionBank
            "JavaScript" -> jsQuestionBank
            "C#" -> cSharpeQuestionBank
            else -> cppQuestionBank
        }

        return when (difficulty) {
            "Easy" -> questionBankFirst[0]
            "Medium" -> questionBankFirst[1]
            "Hard" -> questionBankFirst[2]
            else -> questionBankFirst[3]
        }
    }

    var questionBank = pythonQuestionBank[0]

    val currentQuestionAnswer: String
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].questionResId

    val currentChoicesText: Int
        get() = questionBank[currentIndex].choicesResId

    fun moveToNext() {
        currentIndex++
    }

}