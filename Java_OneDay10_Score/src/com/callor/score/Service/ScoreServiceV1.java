package com.callor.score.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV1 {

	protected Scanner scan;
	protected List<ScoreVO> scoreVO;

	public ScoreServiceV1() {
		// TODO Auto-generated constructor stub
		scan = new Scanner(System.in);
		scoreVO = new ArrayList<ScoreVO>();

	}

	public void serviceStart() {
		while (true) {
			System.out.println("=".repeat(50));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(50));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(50));

			System.out.print("업무선택 >> ");
			String selec1 = scan.nextLine();
			if (selec1.equals("1")) {
				this.makeScore();
			} else if (selec1.equals("2")) {
				this.scoreList(null);
			} else if (selec1.equals("QUIT")) {
				System.out.println("GOOD BYE");
				return;
			} else {
				System.out.println("[1], [2], [QUIT] 만 입력할 수 있습니다.");
				System.out.println("다시 입력해주세요.");
			}
		} // while end

	} // serviceStart end

	public void makeScore() {
		while(true) {
		int intSum = 0;
		float floatAvg = 0.0f;

		ScoreVO sVO = new ScoreVO();

		// this.makeScoreInfo(sVO);
		String strNames = this.makeScoreInfo();
		if (strNames == null) {
			return;
		}
		sVO.setNames(strNames);
		
		Integer intKor = this.korScore();
		if (intKor == null) {
			return;
		}
		sVO.setKor(intKor);
		
		Integer intEng = this.engScore();
		if (intEng == null) {
			return;
		}
		sVO.setEng(intEng);
		
		Integer intMath = this.mathScore();
		if (intMath == null) {
			return;
		}
		sVO.setMath(intMath);
		
		Integer intScien = this.scienScore();
		if (intScien == null) {
			return;
		}
		sVO.setScien(intScien);
		
		Integer intKhis = this.khisScore();
		if (intKhis == null) {
			return;
		}
		sVO.setKhis(intKhis);
		
		
		
		
		intSum = intKor;
		intSum += intEng;
		intSum += intMath;
		intSum += intScien;
		intSum += intKhis;
		floatAvg = intSum / 5.0f;

		sVO.setSum(intSum);
		sVO.setAvg(floatAvg);

		scoreVO.add(sVO);
		this.scorePrint(sVO);
		System.out.println("계속 입력하시겠습니까?");
		System.out.println("1. 계속입력할래!");
		System.out.println("0. 그만입력하고 메뉴로갈래!");
		
		String selec1 = scan.nextLine();
		if(selec1.equals("1")) {
			continue;
		}else if(selec1.equals("0")) {
			break;
		}
		
			
		}
	} // makeScore end

	public void scoreList(ScoreVO vo) {
		System.out.println("=".repeat(50));
		System.out.println("순번\t이름\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		System.out.println("-".repeat(50));
		int sumKor = 0;
		int sumEng = 0;
		int sumMath = 0;
		int sumScien = 0;
		int sumKhis = 0;
		int allSum = 0;
		float allAvg = 0.0f;

		for (int i = 0; i < scoreVO.size(); i++) {
			vo = scoreVO.get(i);
			System.out.print(i + 1 + "\t");
			System.out.print(vo.getNames() + "\t");
			System.out.print(vo.getKor() + "\t");
			sumKor += vo.getKor();
			System.out.print(vo.getEng() + "\t");
			sumEng += vo.getEng();
			System.out.print(vo.getMath() + "\t");
			sumMath += vo.getMath();
			System.out.print(vo.getScien() + "\t");
			sumScien += vo.getScien();
			System.out.print(vo.getKhis() + "\t");
			sumKhis += vo.getKhis();
			System.out.print(vo.getSum() + "\t");
			allSum += vo.getSum();
			System.out.printf("%3.2f\n", vo.getAvg());
		}
		allAvg = allSum / 5.0f / scoreVO.size();

		System.out.printf("총점\t\t%d\t%d\t%d\t%d\t%d\t%d\t%3.2f\n", sumKor, sumEng, sumMath, sumScien, sumKhis, allSum,
				allAvg);
	} // scoreList

	public void scorePrint(ScoreVO vo) {
		System.out.println("=".repeat(50));
		System.out.println(vo.getNames() + " 학생의 성적이 추가 되었습니다.");
		System.out.println("=".repeat(50));
		System.out.println("국어 : " + vo.getKor());
		System.out.println("영어 : " + vo.getEng());
		System.out.println("수학 : " + vo.getMath());
		System.out.println("과학 : " + vo.getScien());
		System.out.println("국사 : " + vo.getKhis());

	} // scorePrint

	public String makeScoreInfo() {
		System.out.println("=".repeat(50));
		System.out.println("학생이름을 입력하세요(입력을 중단하려면 [QUIT])");
		System.out.println("=".repeat(50));
		System.out.print("이름 >> ");
		String strNames = scan.nextLine();
		if (strNames.equals("QUIT")) {
			System.out.println("GOOD BYE");
			return null;
		}
		return strNames;
	} // makeScoreInfo

	public Integer korScore() {
		while (true) {
			System.out.print("국어 >> ");
			String strKor = scan.nextLine();
			if (strKor.equals("QUIT")) {
				System.out.println("GOOD BYE");
				return null;
			}
			Integer intKor = 0;
			try {
				intKor = Integer.valueOf(strKor);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수만 입력가능합니다. 다시입력하세요.");
				continue;
			}
			if (intKor >= 0 && intKor <= 100) {
				return intKor;
			} else {
				System.out.println("0 ~ 100까지만 입력가능합니다. 다시입력하세요.");
				continue;
			}
		}
	}
	
	public Integer engScore() {
		while (true) {
			System.out.print("영어 >> ");
			String strEng = scan.nextLine();
			if (strEng.equals("QUIT")) {
				System.out.println("GOOD BYE");
				return null;
			}
			Integer intEng = 0;
			try {
				intEng = Integer.valueOf(strEng);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수만 입력가능합니다. 다시입력하세요.");
				continue;
			}
			if (intEng >= 0 && intEng <= 100) {
				return intEng;
			} else {
				System.out.println("0 ~ 100까지만 입력가능합니다. 다시입력하세요.");
				continue;
			}
		}
	}
	
	public Integer mathScore() {
		while (true) {
			System.out.print("수학 >> ");
			String strMath = scan.nextLine();
			if (strMath.equals("QUIT")) {
				System.out.println("GOOD BYE");
				return null;
			}
			Integer intMath = 0;
			try {
				intMath = Integer.valueOf(strMath);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수만 입력가능합니다. 다시입력하세요.");
				continue;
			}
			if (intMath >= 0 && intMath <= 100) {
				return intMath;
			} else {
				System.out.println("0 ~ 100까지만 입력가능합니다. 다시입력하세요.");
				continue;
			}
		}
	}
	public Integer scienScore() {
		while (true) {
			System.out.print("과학 >> ");
			String strScien = scan.nextLine();
			if (strScien.equals("QUIT")) {
				System.out.println("GOOD BYE");
				return null;
			}
			Integer intScien = 0;
			try {
				intScien = Integer.valueOf(strScien);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수만 입력가능합니다. 다시입력하세요.");
				continue;
			}
			if (intScien >= 0 && intScien <= 100) {
				return intScien;
			} else {
				System.out.println("0 ~ 100까지만 입력가능합니다. 다시입력하세요.");
				continue;
			}
		}
	}
	
	public Integer khisScore() {
		while (true) {
			System.out.print("국사 >> ");
			String strKhis = scan.nextLine();
			if (strKhis.equals("QUIT")) {
				System.out.println("GOOD BYE");
				return null;
			}
			Integer intKhis = 0;
			try {
				intKhis = Integer.valueOf(strKhis);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수만 입력가능합니다. 다시입력하세요.");
				continue;
			}
			if (intKhis >= 0 && intKhis <= 100) {
				return intKhis;
			} else {
				System.out.println("0 ~ 100까지만 입력가능합니다. 다시입력하세요.");
				continue;
			}
		}
	}

}