package com.bene_gesserit.fragtest

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Stack

open class DataViewModel : ViewModel() {

    private val _uiState = mutableStateOf<SurveyUiState>(SurveyUiState.StartState())
    val uiState: State<SurveyUiState> = _uiState

    val message: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val report: MutableLiveData<Report> by lazy {
        MutableLiveData<Report>()
    }
    val backstack = Stack<Int>()

    /**
     * Следующий вопрос
     * @param nextId номер следующего вопроса
     * @param data данные с экрана
     */
    fun next(nextId: Int, data: Map<String, String> = mapOf()) {
        backstack.add(uiState.value.id)
        Log.i("MyLog", "currentId ${uiState.value.id} nextId $nextId data $data")

        _uiState.value = getSurveyUiStateById(nextId)
    }

    /**
     * Предыдущий вопрос
     */
    fun previous() {
        val id = backstack.pop()
        _uiState.value = getSurveyUiStateById(id)
    }

    private fun getSurveyUiStateById(id: Int): SurveyUiState {
        return when (id) {
            0 -> SurveyUiState.StartState()
            1 -> SurveyUiState.Question1()
            2 -> SurveyUiState.Question2()
            4 -> SurveyUiState.Question4()
            else -> throw IllegalArgumentException("Unknown id: $id")
        }
    }
}

sealed class SurveyUiState(open val id: Int) {

    data class StartState(
        val buttonText: String = "Сообщить о симптомах",
        override val id: Int = 0,
    ) : SurveyUiState(id = id)

    data class Question1(
        val titleText: String = "Когда возникают симптомы",
        val checkBox: String = "Меня беспокоит отдышка",
        val description: String = "Отметьте, если у Вас отстутствуют боли, но ощущается отдышка",
        override val id: Int = 1,
    ) : SurveyUiState(id = id)

    data class Question2(
        val listCheckBox: List<DropListContent> = listOf(
            DropListContent(
                "Где ощущается боль",
                listOf(
                    "За грудиной", "Вариант 2", "Вариант 3"
                )
            ),
            DropListContent(
                "Какие ощущения боли",
                listOf(
                    "Вариант 1", "Вариант 2", "Вариант 3"
                )
            ),
            DropListContent(
                "Какая сила боли",
                listOf(
                    "Вариант 1", "Вариант 2", "Вариант 3"
                )
            ),
        ),
        override val id: Int = 2,
    ) : SurveyUiState(id = id)

    data class Question4(override val id: Int = 4,): SurveyUiState(id = id)
}

data class DropListContent(
    val title: String,
    val dropList: List<String>,
)



