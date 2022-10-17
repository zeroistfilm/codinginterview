package StackAndQueue;

import java.util.Random;

/**
 * 기본적인 push와 pop 기능이 구현된 스택에서 최솟값을 반환하는 min함수를 추가하려고 한다. 어떻게 설계할 수 있겠는가?
 * push, pop, min 연산은 모두 O(1) 시간에 동작해야한다.
 */
public class StackMin {

  /*
   * BasicStack을 상속하고, 최솟값의 정보를 담은 minValueStack 필드를 추가한다.
   * minValueStack은 BasicStack의 자료구조이나 다음과 같은 정책을 가진다.
   * - minValueStack의 최상위 value는 본체 Stack 요소 중에서 가장 최솟값이다.
   * - 본체 Stack에 push하는 값이 minValueStack.peek() 값보다 작으면 minValueStack에도 push한다.
   * - 본체 Stack에 pop하는 값이 minValueStack.peek() 값보다 작으면 minValueStack에도 pop한다.
   */
  public static void main(String[] args) {
    StackWithMin stack = new StackWithMin(11);
    int min = 0;
    int max = 10;
    for (int i = 10; i > 0 ; i--) {
      stack.push((int) ((Math.random() * (max - min)) + min));
      System.out.printf("Stack: %s\n", stack);
      System.out.printf("Min value of this stack: %s\n", stack.min());
    }

    System.out.println("-----------------------------------------");

    while(true) {
      try {
      stack.pop();
      System.out.printf("Stack: %s\n", stack);
      System.out.printf("Min value of this stack: %s\n", stack.min());
      } catch (Exception e) {
        break;
      }
    }

  }

  public static class StackWithMin extends BasicStack<Integer> {

    private final BasicStack<Integer> minValueStack;

    public StackWithMin(Integer initData) {
      super(initData);
      this.minValueStack = new BasicStack<>(initData);
    }

    @Override
    public Integer pop() {
      int value =  super.pop();
      if (value == minValueStack.peek()) {
        minValueStack.pop();
      }
      return value;
    }

    @Override
    public void push(Integer item) {
      super.push(item);
      if (minValueStack.peek() > item) {
        minValueStack.push(item);
      }
    }

    public Integer min() {
      return minValueStack.peek();
    }
  }
}
