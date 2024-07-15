class Solution {
    public String countOfAtoms(String formula) {
        List<String> list = preprocess(formula);
        Map<String, Integer> atomCount = count(list, 1);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : atomCount.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue().toString());
            }
        }
        return sb.toString();
    }

    private Map<String, Integer> count(List<String> list, int totalRepeat) {
        Map<String, Integer> countMap = new TreeMap<>();
        int n = list.size();
        int currIndex = 0;
        Stack<Integer> st = new Stack<>();
        while (currIndex < n) {
            String currString = list.get(currIndex);
            if (st.isEmpty()) {
                if (Character.isLetter(currString.charAt(0))) {
                    ++currIndex;
                    int count = 1;
                    if (currIndex < n && Character.isDigit(list.get(currIndex).charAt(0))) {
                        count = Integer.valueOf(list.get(currIndex));
                        ++currIndex;
                    }
                    countMap.put(currString, countMap.getOrDefault(currString, 0) + count * totalRepeat);
                } else if (Character.isDigit(currString.charAt(0))) {
                    ++currIndex;
                } else {
                    // currString == "("
                    st.push(currIndex);
                    ++currIndex;
                }
            } else {
                // stack is not empty
                if (currString.equals("(")) {
                    st.push(currIndex);
                    ++currIndex;
                } else if (currString.equals(")")) {
                    int subRepeat = 1;
                    if (currIndex + 1 < n && Character.isDigit(list.get(currIndex + 1).charAt(0))) {
                        subRepeat = Integer.valueOf(list.get(currIndex + 1));
                    }
                    int startIndex = st.pop();
                    ++currIndex;
                    if (st.isEmpty()) {
                        List<String> sublist = list.subList(startIndex + 1, currIndex - 1);
                        Map<String, Integer> subresult = count(sublist, subRepeat * totalRepeat);
                        for (Map.Entry<String, Integer> entry : subresult.entrySet()) {
                            countMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
                        }
                    }
                } else {
                    ++currIndex;
                }
            }
        }
        return countMap;
    }

    // return an integer that indicating the starting index of next block.
    private int getBlock(String formula, int index) {
        char ch = formula.charAt(index);
        int n = formula.length();
        int nextStartIndex = index + 1;
        if (Character.isDigit(ch)) {
            while (nextStartIndex < n) {
                if (Character.isDigit(formula.charAt(nextStartIndex))) {
                    ++nextStartIndex;
                } else {
                    break;
                }
            }
        } else {
            while (nextStartIndex < n) {
                if (Character.isLowerCase(formula.charAt(nextStartIndex))) {
                    ++nextStartIndex;
                } else {
                    break;
                }
            }
        }
        return nextStartIndex;
    }

    private List<String> preprocess(String formula) {
        List<String> result = new ArrayList<>();
        int n = formula.length();
        char[] formulaArray = formula.toCharArray();
        int currIndex = 0;
        while (currIndex < n) {
            char ch = formulaArray[currIndex];
            if (Character.isDigit(ch) || Character.isUpperCase(ch)) {
                int nextStartIndex = getBlock(formula, currIndex);
                result.add(formula.substring(currIndex, nextStartIndex));
                currIndex = nextStartIndex;
            } else if (ch == '(' || ch == ')') {
                int nextStartIndex = currIndex + 1;
                result.add(formula.substring(currIndex, nextStartIndex));
                currIndex = nextStartIndex;
            } else {
                ++currIndex;
                continue;
            }
        }
        return result;
    }
}