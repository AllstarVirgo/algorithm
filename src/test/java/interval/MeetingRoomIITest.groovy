package interval

import spock.lang.Specification

class MeetingRoomIITest extends Specification {
    def "MinMeetingRooms"() {
        given:
        def mr = new MeetingRoomII();
        int[][] intervals = [[0, 30], [5, 10], [15, 20]];

        expect:
        mr.minMeetingRooms(intervals) == 2
    }
}
