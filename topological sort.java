public static void main(String[] args) {
    int n = 4;
    int m = 5;
    String[] inputs = new String[m];
    inputs[0] = "bc";
    inputs[1] = "dc";
    inputs[2] = "ad";
    inputs[3] = "bd";
    inputs[4] = "ba";
    char[] letters = {'a', 'b', 'c', 'd'};

    Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
    Map<Character, Integer> indegrees = new HashMap<Character, Integer>();
    for (char c: letters) {
      graph.put(c, new ArrayList<Character>());
      indegrees.put(c, 0);
    }

    for (String s: inputs) {
      char from = s.charAt(0);
      char to = s.charAt(1);
      graph.get(from).add(to);
      indegrees.put(to, indegrees.get(to) + 1);
    }

    List<Character> orderLetters = populateLetterInOrder(graph, indegrees);
    System.out.println("order letters:" + orderLetters);
  }

  private static List<Character> populateLetterInOrder(Map<Character, List<Character>> graph,
      Map<Character, Integer> indegrees) {
    List<Character> res = new ArrayList<Character>();
    Queue<Character> queue = new LinkedList<Character>();
    boolean[] visited = new boolean[256];

    for (Map.Entry<Character, Integer> entry: indegrees.entrySet()) {
      if (entry.getValue() == 0)
        queue.add(entry.getKey());
    }

    while (!queue.isEmpty()) {
      char c = queue.poll();
      res.add(c);
      visited[c] = true;
      for (char neighbour: graph.get(c)) {
        if (visited[neighbour])
          break; // cycle detected
        indegrees.put(neighbour, indegrees.get(neighbour)-1);
        if (indegrees.get(neighbour) == 0)
          queue.add(neighbour);
      }
    }
    return res;
  }
