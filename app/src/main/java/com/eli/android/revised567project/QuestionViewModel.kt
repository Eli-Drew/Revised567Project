package com.example.elirinker.quizgame

import androidx.lifecycle.ViewModel
import com.eli.android.revised567project.R

class QuestionViewModel: ViewModel() {

    var currentIndex = 0
    //    var questionBank: List<Question>? = null
    var correctAnswers = 0

    private val cppEasyQuestionBank = listOf(
        Question(R.string.cppEasyQuestion1, R.string.cppEasyChoices1, "A", "CPP", "Easy"),
        Question(R.string.easyCPPThree, R.string.easyCPPThreeAns, "A", "CPP", "Easy")
    )

    private val cppMediumQuestionBank = listOf(
        Question(R.string.cppMediumQues1, R.string.cppMediumChoices1, "B", "CPP", "Medium"),
        Question(R.string.medCPPThree, R.string.medCPPThreeAns, "B", "CPP", "Medium")
    )

    private val cppHardQuestionBank = listOf(
        Question(R.string.cppHardQues1, R.string.cppHardChoices1, "C", "CPP", "Hard"),
        Question(R.string.hardCPPThree, R.string.hardCPPThreeAns, "C", "CPP", "Hard")
    )

    private val cppProdigyQuestionBank = listOf(
        Question(R.string.cppProdigyQues1, R.string.cppProdigyChoices1, "D", "CPP", "Prodigy"),
        Question(R.string.prodigyCPPThree, R.string.prodigyCPPThreeAns, "C", "CPP", "Prodigy")
    )

    private val cppQuestionBank = listOf(
        cppEasyQuestionBank,
        cppMediumQuestionBank,
        cppHardQuestionBank,
        cppProdigyQuestionBank
    )

    private val easyCSharpeQuestionBank = listOf(
        Question(R.string.easyCSOne, R.string.easyCSOneAns, "C", "C#", "Easy"),
        Question(R.string.easyCSTwo, R.string.easyCSTwoAns, "B", "C#", "Easy"),
        Question(R.string.easyCSOne, R.string.easyCSOneAns, "C", "C#", "Easy"),
        Question(R.string.easyCSTwo, R.string.easyCSTwoAns, "B", "C#", "Easy"),
        Question(R.string.easyCSThree, R.string.easyCSThreeAns, "B", "C#", "Easy"),
        Question(R.string.easyCSFour, R.string.easyCSFourAns, "C", "C#", "Easy"),
        Question(R.string.easyCSFive, R.string.easyCSFiveAns, "C", "C#", "Easy"),
        Question(R.string.easyCSSix, R.string.easyCSSixAns, "C", "C#", "Easy")
    )

    private val mediumCSharpeQuestionBank = listOf(
        Question(R.string.medCSOne, R.string.medCSOneAns, "A", "C#", "Medium"),
        Question(R.string.medCSTwo, R.string.medCSTwoAns, "B", "C#", "Medium"),
        Question(R.string.medCSOne, R.string.medCSOneAns, "A", "C#", "Medium"),
        Question(R.string.medCSTwo, R.string.medCSTwoAns, "B", "C#", "Medium"),
        Question(R.string.medCSThree, R.string.medCSThreeAns, "C", "C#", "Medium"),
        Question(R.string.medCSFour, R.string.medCSFourAns, "C", "C#", "Medium"),
        Question(R.string.medCSFive, R.string.medCSFiveAns, "C", "C#", "Medium"),
        Question(R.string.medCSSix, R.string.medCSSixAns, "A", "C#", "Medium")
    )

    private val hardCSharpeQuesitonBank = listOf(
        Question(R.string.hardCSOne, R.string.hardCSOneAns, "C", "C#", "Hard"),
        Question(R.string.hardCSTwo, R.string.hardCSTwoAns, "B", "C#", "Hard"),
        Question(R.string.hardCSOne, R.string.hardCSOneAns, "C", "C#", "Hard"),
        Question(R.string.hardCSTwo, R.string.hardCSTwoAns, "B", "C#", "Hard"),
        Question(R.string.hardCSThree, R.string.hardCSThreeAns, "A", "C#", "Hard"),
        Question(R.string.hardCSFour, R.string.hardCSFourAns, "C", "C#", "Hard"),
        Question(R.string.hardCSFive, R.string.hardCSFiveAns, "C", "C#", "Hard"),
        Question(R.string.hardCSSix, R.string.hardCSSixAns, "B ", "C#", "Hard")
    )

    private val prodigyCSharpeQuestionBank = listOf(
        Question(R.string.prodigyCSOne, R.string.prodigyCSOneAns, "C", "C#", "Prodigy"),
        Question(R.string.prodigyCSTwo, R.string.prodigyCSTwoAns, "A", "C#", "Prodigy"),
        Question(R.string.prodigyCSOne, R.string.prodigyCSOneAns, "C", "C#", "Prodigy"),
        Question(R.string.prodigyCSTwo, R.string.prodigyCSTwoAns, "A", "C#", "Prodigy"),
        Question(R.string.prodigyCSThree, R.string.prodigyCSThreeAns, "B ", "C#", "Prodigy"),
        Question(R.string.prodigyCSFour, R.string.prodigyCSFourAns, "B", "C#", "Prodigy"),
        Question(R.string.prodigyCSFive, R.string.prodigyCSFiveAns, "C", "C#", "Prodigy"),
        Question(R.string.prodigyCSSix, R.string.prodigyCSSixAns, "A", "C#", "Prodigy")
    )

    private val cSharpeQuestionBank = listOf(
        easyCSharpeQuestionBank,
        mediumCSharpeQuestionBank,
        hardCSharpeQuesitonBank,
        prodigyCSharpeQuestionBank
    )

    private val easyJsQuestionBank = listOf(
        Question(R.string.easyJSOne, R.string.easyJSOneAns, "C", "JavaScript", "Easy"),
        Question(R.string.easyJSTwo, R.string.easyCSTwoAns, "C", "JavaScript", "Easy"),
        Question(R.string.easyJSOne, R.string.easyJSOneAns, "C", "JavaScript", "Easy"),
        Question(R.string.easyJSTwo, R.string.easyCSTwoAns, "C", "JavaScript", "Easy"),
        Question(R.string.easyJSThree, R.string.easyJSThreeAns, "A", "JS", "Easy")
    )

    private val mediumJsQuestionBank = listOf(
        Question(R.string.medJSOne, R.string.medJSOneAns, "C", "JavaScript", "Medium"),
        Question(R.string.medJSTwo, R.string.medJSTwoAns, "A", "JavaScript", "Medium"),
        Question(R.string.medJSOne, R.string.medJSOneAns, "C", "JavaScript", "Medium"),
        Question(R.string.medJSTwo, R.string.medJSTwoAns, "A", "JavaScript", "Medium"),
        Question(R.string.medJSThree, R.string.medJSThreeAns, "A", "JS", "Medium")
    )

    private val hardJsQuestionBank = listOf(
        Question(R.string.hardJSOne, R.string.hardJSOneAns, "A", "JavaScript", "Hard"),
        Question(R.string.hardJSTwo, R.string.hardCSTwoAns, "B", "JavaScript", "Hard"),
        Question(R.string.hardJSOne, R.string.hardJSOneAns, "A", "JavaScript", "Hard"),
        Question(R.string.hardJSTwo, R.string.hardCSTwoAns, "B", "JavaScript", "Hard"),
        Question(R.string.hardJSThree, R.string.hardJSThreeAns, "B", "JS", "Hard")
    )

    private val prodigyJsQuestionBank = listOf(
        Question(R.string.prodigyJSOne, R.string.prodigyJSOneAns, "C", "JavaScript", "Prodigy"),
        Question(R.string.prodigyJSTwo, R.string.prodigyJSTwoAns, "C", "JavaScript", "Prodigy"),
        Question(R.string.prodigyJSOne, R.string.prodigyJSOneAns, "C", "JavaScript", "Prodigy"),
        Question(R.string.prodigyJSTwo, R.string.prodigyJSTwoAns, "C", "JavaScript", "Prodigy"),
        Question(R.string.prodigyJSThree, R.string.prodigyJSThreeAns, "D", "JS", "Prodigy")
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

