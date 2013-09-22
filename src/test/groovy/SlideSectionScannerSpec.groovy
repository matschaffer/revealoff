import spock.lang.Specification
import SlideSectionScanner

class SlideSectionScannerSpec extends Specification {
    def "generates a slide section from a markdown file"() {
        when:
        def sections = SlideSectionScanner.scan("src/test/resources/sections/single")

        then:
        sections.size() == 1
    }

    def "generates a section with multiple files"() {
        when:
        def sections = SlideSectionScanner.scan("src/test/resources/sections/multiple")

        then:
        sections.size() == 1
        sections.get(0).getSlides().size() == 2
    }

//    def "generates multiple sections when nested"() {
//        when:
//        def sections = SlideSectionScanner.scan("src/test/resources/sections/nested")
//
//        then:
//        sections.size() == 2
//        sections.get(0).getSlides().size() == 1
//        sections.get(1).getSlides().size() == 1
//    }
}
