package org.example.bookfd.restControllers.test

import org.example.bookfd.domain.Questions
import org.example.bookfd.domain.TestsNames
import org.example.bookfd.repos.QuestionsRepo
import org.example.bookfd.repos.TestsNamesRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class TestRestController @Autowired constructor(
    private val testsNamesRepo: TestsNamesRepo,
    private val questionsRepo: QuestionsRepo
) {

    private var idTest = 0

    /*
        Get list tests in selected subject
    */
    @RequestMapping(
        value = ["/ListTestsNames"],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getListTests(@RequestParam(name="subject", required=false, defaultValue="физика") subject:String) = testsNamesRepo.findBySubject(subject)

    /*
        Add questions in test
    */
    @PostMapping("/addquestion")
    fun addQuestions(@RequestBody listQuestions:List<Questions>){
        for (question in listQuestions){
            question.testid = idTest
            questionsRepo.save(question)
        }
    }

    /*
        Add test with information
    */
    @PostMapping("/addtest")
    fun addTest(@RequestBody testsNames: TestsNames){
        testsNamesRepo.save(testsNames)
        idTest = testsNames.id
    }
}