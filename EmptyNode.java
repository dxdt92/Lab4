/**
 * Represents the end of a sentence (base case).
 */
public class EmptyNode implements Sentence {

  /**
   * Returns nothing because there are no more words
   * at the end of a sentence.
   *
   * @return 0
   */
  @Override
  public int getNumberOfWords() {
    return 0;
  }

  /**
   * Helper method for recursively counting the word nodes in a sentence.
   * In EmptyNode, it returns the current count.
   *
   * @param count the accumulated word count
   * @return the word count
   */
  @Override
  public int getNumberOfWordsHelper(int count) {
    return count;
  }

  /**
   * Returns an empty string because there are no words
   * in an empty node.
   *
   * @return empty string
   */
  @Override
  public String longestWord() {
    return "";
  }

  /**
   * Returns an empty string because there are no more
   * sentences to build.
   *
   * @return empty string
   */
  @Override
  public String toString() {
    return "";
  }

  /**
   * Returns the final sentence string with the appended punctuation.
   *
   * @param append the accumulated sentence
   * @param endString the String to add at the end
   * @return the completed sentence string
   */
  @Override
  public String toStringHelper(String append, String endString) {
    return append + endString;
  }

  /**
   * Returns a duplicate of the empty node.
   *
   * @return a clone of EmptyNode
   */
  @Override
  public Sentence clone() {
    return new EmptyNode();
  }

  /**
   * Merges this empty node with another sentence by returning
   * a clone of the other sentence.
   *
   * @param other the sentence to be merged
   * @return the merged sentence with this empty node
   */
  @Override
  public Sentence merge(Sentence other) {
    return other.clone();
  }
}