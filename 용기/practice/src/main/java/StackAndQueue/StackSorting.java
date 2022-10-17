package StackAndQueue;

public class StackSorting {

  /*
   * 여분 Stack을 하나 생성한다.
   * 본 Stack에서 하나씩 pop한다.
   * pop한 값이 여분 Stack의 peek값 (여분 스택의 최댓값이 될 것이다.) 보다 크다면 그대로 push한다.
   * pop한 값(temp)이 여분 Stack의 peek값 보다 작다면 pop을 실행한다.
   * temp가 여분 Stack의 peek값보다 크다면 pop을 중지하고, temp를 여분 Stack에 push 한다.
   * 본 Stack이 모두 비워질 때까지 반복한다.
   * 본 Stack이 모두 비워지면, 다시 여분 Stack에서 하나씩 pop하여 본 Stack에 집어넣는다.
   */
  public static void main(String[] args) {
    BasicStack<Integer> stack = new BasicStack<>(1);
    int min = 0;
    int max = 10;
    for (int i = 10; i > 0; i--) {
      stack.push((int) ((Math.random() * (max - min)) + min));
    }
    System.out.printf("Stack before sorting: %s\n", stack);

    SortProgram program = new SortProgram(stack);
    BasicStack<Integer> sorted = program.sort();

    System.out.printf("Stack after sorting: %s\n", sorted);
  }

  public static class SortProgram {

    private BasicStack<Integer> mainStack;
    private BasicStack<Integer> subStack;

    public SortProgram(BasicStack<Integer> mainStack) {
      this.mainStack = mainStack;
    }

    public BasicStack<Integer> sort() {
      // 여분 스택 생성
      this.subStack = new BasicStack<>(mainStack.pop());

      while (!mainStack.isEmpty()) {
        Integer tmp = mainStack.pop();
        while (!subStack.isEmpty() && tmp < subStack.peek()) {
          mainStack.push(subStack.pop());
        }
        subStack.push(tmp);
      }

      while (!subStack.isEmpty()) {
        mainStack.push(subStack.pop());
      }
      return mainStack;
    }
  }
}
