public interface Sentence {
  int getNumberOfWords();
  int getNumberOfWordsHelper(int count);
  String longestWord();
  String toString();
  String toStringHelper(String accum, String end);

  Sentence clone();
  Sentence merge(Sentence other);
}