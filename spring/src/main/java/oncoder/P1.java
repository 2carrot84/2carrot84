package oncoder;


public class P1 {
	public int solution(int[] seq) {
		// �������� ����
		int sequenceLength = 1;
		// ����(0)/����(1) ���а�
		boolean isAes = false;
		// �ְ� ����
		int maxLength = 1;
		
		if(seq.length < 1 || 50 < seq.length ) {
			System.err.println("����� ������ �߸��Ǿ����ϴ�.");
			return -1;
		}
		
		for (int i = 0; i < seq.length-1; i++) {
			if(seq[i] < 1 || 100 < seq[i]) {
				System.err.println("����� ���� ������ �߸��Ǿ����ϴ�.");
				return -1;
			}
			
			// �迭���۽� �Ǵ� ���� ������� ����/���� ���а� ����
			if(i == 0 || sequenceLength == 1) {
				if(seq[i] < seq[i+1]) {
					isAes = true;	// ��������
				}
				else if(seq[i] > seq[i+1]){
					isAes = false;	// ��������
				}
			}

			if(isAes) {	// ���������� ���
				if(seq[i] < seq[i+1]) {	// ���� �迭 ���� ũ�� count ����
					isAes = true;
					sequenceLength++;
					maxLength = this.diffMax(maxLength, sequenceLength);	// �ְ� ���� ���ϱ�
				}
				else if(seq[i] > seq[i+1]) {	// ���� �迭 ���� ������ count ����
					isAes = false;
					sequenceLength = 2;
				}
				else {	// ���� �迭 ���� ������ count �ʱ�ȭ
					isAes = false;
					sequenceLength = 1;
				}
			}
			else if(!isAes) {	// ���������� ���
				if(seq[i] > seq[i+1]) {	// ���� �迭 ���� ������ count ����
					isAes = false;
					sequenceLength++;
					maxLength = this.diffMax(maxLength, sequenceLength);	// �ְ� ���� ���ϱ�
				}
				else if(seq[i] < seq[i+1]) {	// ���� �迭 ���� ũ�� count ����
					isAes = true;
					sequenceLength = 2;
				}
				else {	// ���� �迭 ���� ũ�ų� ������ count �ʱ�ȭ
					isAes = true;
					sequenceLength = 1;
				}
			}
		}
		return maxLength;
	}
	
	private int diffMax(int a, int b) {
		return a<b?b:a;
	}
	
	public static void main(String[] args) {
		P1 p = new P1();
    	
    	int[] s1 = {1,7,7,8,3,6,7,2};
    	System.out.println("�������� ���̴� " + p.solution(s1));
	}

}
