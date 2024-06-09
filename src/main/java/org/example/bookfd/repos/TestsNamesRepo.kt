package org.example.bookfd.repos

import org.example.bookfd.domain.TestsNames
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TestsNamesRepo : CrudRepository<TestsNames?, Int?> {
    fun findBySubjectAndNumclass(subject: String?, numclass: Int): List<TestsNames?>?
    fun findBySubject(subject: String?): List<TestsNames?>?
    fun findByNumclass(numclass: Int): List<TestsNames?>?
    fun findByNametest(name_test: String?): TestsNames?
    fun findById(id: Int): TestsNames?
}
