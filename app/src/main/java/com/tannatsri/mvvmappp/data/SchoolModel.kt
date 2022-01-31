package com.tannatsri.mvvmappp.data



data class SchoolData (val school : List<SchoolModel>)

data class SchoolModel(
    val name: String?,
    val country: String?,
    val alpha_two_code: String?,

    )
