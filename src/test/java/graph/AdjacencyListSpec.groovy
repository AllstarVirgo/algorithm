package graph

import spock.lang.Specification

class AdjacencyListSpec extends Specification {

    def "add direct edge"() {
        given: "An adjacency list for directed graph"
        def adjacencyList = new AdjacencyList(3)

        when: "Add a direct edge"
        adjacencyList.addDirect(0, 1)

        then: "The edge is correctly added"
        adjacencyList.list.get(0) == [1]
    }

    def "add undirect edge and perform BFS"() {
        given: "An adjacency list for undirected graph and add edges"
        def adjacencyList = new AdjacencyList(4)
        adjacencyList.addUnDirect(0, 1)
        adjacencyList.addUnDirect(1, 2)
        adjacencyList.addUnDirect(2, 3)

        when: "Perform BFS from vertex 0 to 3"
        def out = new ByteArrayOutputStream()
        System.setOut(new PrintStream(out))
        adjacencyList.bfs(0, 3)

        then: "The BFS should visit nodes in correct order"
        out.toString().trim() == "0\n1\n2\n3"
    }
}
