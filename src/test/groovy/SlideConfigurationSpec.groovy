import spock.lang.Specification

/**
 * Author: Mat Schaffer <matschaffer@netflix.com>
 * Created: 8/20/13 10:15 PM
 */
class SlideConfigurationSpec extends Specification {
    def config

    def "parses the given config file"() {
        when:
        config = SlideConfiguration.parse(new File("src/test/resources/config.json"))

        then:
        // in JSON file
        config.author == "Mat"

        // defaults
        config.title == "Revealoff"
        config.description == null
        config.theme == "default"
    }

    def "contains original json"() {
        when:
        config = SlideConfiguration.parse(new File("src/test/resources/config.json"))

        then:
        config.json == '{ "author": "Mat" }'
    }
}
