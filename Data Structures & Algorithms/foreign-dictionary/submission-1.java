class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character> > graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                graph.computeIfAbsent(ch, key -> new HashSet<>());
                inDegree.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            int j = i + 1;
            for (int k = 0; k < Math.max(words[i].length(), words[j].length()); k++) {
                if (words[i].length() <= k)
                    break;
                if (words[j].length() <= k)
                    return "";
                char c1 = words[i].charAt(k);
                char c2 = words[j].charAt(k);
                if (c1 == c2)
                    continue;
                if (graph.get(c1).add(c2)) {
                    inDegree.merge(c2, 1, Integer::sum);
                }
                break;
            }
        }

        Queue<Character> kahn = new ArrayDeque<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.getOrDefault(c, 0) == 0) {
                kahn.offer(c);
            }
        }

        List<Character> result = new ArrayList<>();

        while (!kahn.isEmpty()) {
            char ch = kahn.poll();
            result.add(ch);

            Set<Character> neighbors = graph.get(ch);
            if (neighbors != null) {
                for (char nbr : neighbors) {
                    if (inDegree.merge(nbr, -1, Integer::sum) == 0) {
                        kahn.offer(nbr);
                    }
                }
            }
        }

        if (result.size() < inDegree.keySet().size())
            return "";
        StringBuilder sb = new StringBuilder();
        for (char ch : result) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
