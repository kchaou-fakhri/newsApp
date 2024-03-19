kover {
    filters {
        classes {
            excludes += listOf("*di.*", "*Factory*")
        }
        annotations {
            excludes += listOf("*Generated", "*CustomAnnotationToExclude")
        }
    }
    htmlReport {
        onCheck.set(true)
    }
    verify {
        rule {
            isEnabled = true
            name = "Line Coverage of Tests must be more than 80%"
        }
    }
}