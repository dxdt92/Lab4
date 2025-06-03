/**
 * Represents a punctuation mark in the sentence.
 */
public class PunctuationNode implements Sentence {
  private final String punctuation;
  private final Sentence next;

  /**
   * Constructs a PunctuationNode with punctuation marks and
   * the next node.
   *
   * @param punctuation punctuation marks ".", ",", "!", "?"
   * @param next the next node in the sentence
   */
  public PunctuationNode(String punctuation, Sentence next) {
    this.punctuation = punctuation;
    this.next = next;
  }

  /**
   * Recursively calculates the number of words in the sentence
   * starting at this node and skips punctuation.
   *
   * @return the number of words in the sentence
   */
  @Override
  public int getNumberOfWords() {
    return next.getNumberOfWordsHelper(0);
  }

  /**
   * Helper method for counting the number of words in a sentence
   * recursively. This method passes the accumulated count to the next
   * node since it accounts for only punctuation strings.
   *
   * @param count the current word count
   * @return the final word count
   */
  @Override
  public int getNumberOfWordsHelper(int count) {
    return this.next.getNumberOfWordsHelper(count);
  }

  /**
   * Recursively finds the longest word and skips punctuation.
   *
   * @return
   */
  @Override
  public String longestWord() {
    return this.next.longestWord();
  }

  /**
   * Recursively builds the String of the sentence from this node.
   *
   * @return the sentence
   */
  @Override
  public String toString() {
    return this.toStringHelper("", ".");
  }

  /**
   * Helper method for accumulating the sentence string recursively
   * and appending the punctuation at the end without a space, then
   * passes to the next node.
   *
   * @param accum the current sentence string
   * @param end the string to append at the end (if applicable)
   * @return the updated sentence string
   */
  @Override
  public String toStringHelper(String accum, String end) {
    String updated = accum + punctuation;
    return next.toStringHelper(updated, end);
  }

  /**
   * Duplicates the punctuation node and the following nodes.
   *
   * @return a clone of the original sentence
   */
  @Override
  public Sentence clone() {
    return new PunctuationNode(this.punctuation, this.next.clone());
  }

  /**
   * Recursively merges this punctuation node with another sentence
   *
   * @param other the other sentence to be merged
   * @return the merged sentence
   */
  @Override
  public Sentence merge(Sentence other) {
    return new PunctuationNode(this.punctuation, this.next.merge(other));
  }
}