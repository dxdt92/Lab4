/**
 * Represents a node that holds a word in a sentence.
 */
public class WordNode implements Sentence {
  private final String word;
  private final Sentence next;

  /**
   * Constructs WordNode with a given word and a reference to the next
   * word node in the sentence.
   *
   * @param word the word in this node
   * @param next the next node in the sentence
   */
  public WordNode(String word, Sentence next) {
    this.word = word;
    this.next = next;
  }

  /**
   * Recursively calculates the number of words in the sentence
   * starting at this node.
   *
   * @return the number of words in the sentence
   */
  @Override
  public int getNumberOfWords() {
    return getNumberOfWordsHelper(0);
  }

  /**
   * Helper method for recursively counting the word nodes in a sentence.
   * This node adds 1 to the count.
   *
   * @param count the current accumulated word count
   * @return the final word count
   */
  @Override
  public int getNumberOfWordsHelper(int count) {
    return next.getNumberOfWordsHelper(count + 1);
  }

  /**
   * Recursively finds the next longest word in the sentence starting
   * from this node.
   *
   * @return the longest word
   */
  @Override
  public String longestWord() {
    String nextLongest = next.longestWord();
    return word.length() >= nextLongest.length() ? word : nextLongest;
  }

  /**
   * Recursively builds the String of the sentence with correct
   * spacing and punctuation.
   *
   * @return the sentence
   */
  @Override
  public String toString() {
    return toStringHelper("", ".");
  }

  /**
   * Helper method that builds the sentence string with a space between
   * each word node.
   *
   * @param accum the currently accumulated sentence string
   * @param end the punctuation string if sentence ends without one
   * @return the updated sentence string
   */
  @Override
  public String toStringHelper(String accum, String end) {
    String updated = accum.isEmpty() ? word : accum + " " + word;
    return next.toStringHelper(updated, end);
  }

  /**
   * Duplicates the sentence starting with this node.
   *
   * @return a clone of the original sentence
   */
  @Override
  public Sentence clone() {
    return new WordNode(this.word, this.next.clone());
  }

  /**
   * Recursively merges this sentence with another and preserves punctuation.
   *
   * @param other the other sentence to be merged
   * @return the merged sentence
   */
  @Override
  public Sentence merge(Sentence other) {
    return new WordNode(this.word, this.next.merge(other));
  }
}