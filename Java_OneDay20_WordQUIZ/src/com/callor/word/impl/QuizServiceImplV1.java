package com.callor.word.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.callor.word.model.WordVO;
import com.callor.word.service.QuizService;

public class QuizServiceImplV1 implements QuizService {

	protected List<WordVO> wordList;
	protected Scanner scan;
	protected Random rnd;
	protected Integer playerPoint;
	private final int 영어 = 0;
	private final int 한글 = 1;

	public QuizServiceImplV1() {
		// TODO Auto-generated constructor stub
		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);
		rnd = new Random();
		playerPoint = 0;

	}

	@Override
	public void selectMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("=".repeat(50));
			System.out.println("\t\t루팡의 영어 단어 퀴즈");
			System.out.println("=".repeat(50));
			System.out.println("1. 게임시작");
			System.out.println("2. 이전게임 불러오기");
			System.out.println("3. 단어리스트 불러오기");
			System.out.println("4. 도움말 및 게임규칙");
			System.out.println("0. 게임종료");
			System.out.println("[주의] 첫 게임시작전 이전게임이나 단어리스트를 꼭 불러오세요.");
			System.out.println("=".repeat(50));
			String selectMenu = scan.nextLine();
			if (selectMenu.equals("1")) {
				this.viewFile();
			} else if (selectMenu.equals("2")) {
				this.loadFile();
			} else if (selectMenu.equals("3")) {
				this.readFile();
			} else if (selectMenu.equals("4")) {
				this.help();
			} else if (selectMenu.equals("0")) {
				return;
			}
		}

	}

	@Override
	public void readFile() {
		// TODO Auto-generated method stub
		while (true) {
			String fileName = "src/com/callor/word/word.txt";

			FileReader fileReader = null;
			BufferedReader buffer = null;

			try {
				fileReader = new FileReader(fileName);
				buffer = new BufferedReader(fileReader);

				while (true) {
					String read = buffer.readLine();
					if (read == null) {
						break;
					}
					String[] readS = read.split(":");

					WordVO wordVO = new WordVO();
					wordVO.setEnglish(readS[영어]);
					wordVO.setKorea(readS[한글]);
					wordList.add(wordVO);
					System.out.println(wordVO.toString());
				}
				buffer.close();

			} catch (FileNotFoundException e) {
				System.out.println("[ERROR]파일을 여는 도중 문제가 발생했습니다.");
			} catch (IOException e) {
				System.out.println("[ERROR]파일 데이터를 읽는 중 문제가 발생했습니다.");
			}

			return;
		}

	}

	@Override
	public void saveFile(Integer playerPoint) {
		String saveName = null;
		while (true) {
			System.out.println("저장하실 파일이름을 영문으로 적어주세요.");
			saveName = scan.nextLine();
			if (saveName.equals("")) {
				continue;
			}
			break;
		}
		String fileName = "src/com/callor/word/" + saveName + ".txt";

		FileWriter fileWriter = null;
		PrintWriter out = null;

		try {
			fileWriter = new FileWriter(fileName);
			out = new PrintWriter(fileWriter);

			out.print(playerPoint);

			out.flush();
			out.close();
			System.out.println("저장완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return;

	}

	@Override
	public void loadFile() {

		System.out.println("저장한 텍스트 이름을 입력하세요(.txt 제외)");
		String load = scan.nextLine();
		String fileName = "src/com/callor/word/" + load + ".txt";

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);

			String readPoint = buffer.readLine();
			Integer point = Integer.valueOf(readPoint);
			playerPoint = point;

			buffer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.readFile();
		return;

	}

	@Override
	public WordVO quiz() {
		// TODO Auto-generated method stub
		WordVO vo = this.getWord(); // getWord에서 무작위로 나온 한줄을 가져와 vo에 담는다
		String strEng = vo.getEnglish();
		String[] strWords = strEng.split(""); // 이러면 단어마다 분리하는건지

		for (int i = 0; i < 100; i++) { // 100번만큼 단어순서를 섞는다.
			int num1 = rnd.nextInt(strWords.length);
			int num2 = rnd.nextInt(strWords.length);

			String shake = strWords[num1]; // 나눠놓은 알파벳에 순번을 랜덤으로 지정해
			strWords[num1] = strWords[num2]; // ex) 랜덤번째를 랜덤번째로 다시랜덤번째는 랜덤번째로 돌려
			strWords[num2] = shake; // 이걸 100번 돌린다.
		}
		System.out.println("=".repeat(50));
		System.out.println(vo.toString());
		System.out.println("[5점]아래 단어를 올바른 순서로 배열하세요.(HELP : 힌트(-2점) / PASS : 다음문제(-3점) / QUIT : 종료");
		System.out.println(Arrays.toString(strWords));
		System.out.println("<".repeat(50));
		System.out.println("-".repeat(50));

		return vo;
	}

	@Override
	public void viewFile() {
		WordVO vo = new WordVO();
		System.out.println(">".repeat(50));
		System.out.println("게임을 시작합니다.");

		while (true) {
			int life = 3;
			System.out.println("문제당 3번의 기회가 있습니다.");

			vo = this.quiz();

			boolean flag = true;
			int pass = 0;
			Integer point = 5;

			while (true) {
				System.out.print("정답은? :");
				String input = scan.nextLine();

				if (input.equals("HELP")) {
					if (playerPoint >= 2) {
						playerPoint -= 2;
						System.out.println("HINT >> 한글 뜻은 [" + vo.getKorea() + "] 입니다.");
						System.out.println("현재 남은 포인트는 " + playerPoint + "점 입니다.");
						continue;
					} else {
						System.out.println("포인트가 부족합니다.");
						continue;
					}
				} else if (input.equals("QUIT")) {
					flag = false;
					break;
				} else if (input.equals("PASS")) {
					if (playerPoint < 3) {
						System.out.println("포인트가 부족합니다.");
						continue;
					}
					
					pass = 1;
					playerPoint = playerPoint - 3;
					System.out.println("현재 남은 포인트는 " + playerPoint + "점");

				} else if (input.equalsIgnoreCase(vo.getEnglish())) {
					playerPoint += point;
					System.out.println("축하합니다. 정답입니다. [+5점]");
					System.out.println(vo.toString());
					System.out.println("현재 남은 포인트는 " + playerPoint + "점 입니다.");
				} else {
					System.out.println("틀렸습니다. 재도전 기회가 " + life + "회, 포인트가 " + playerPoint + "점 남았습니다.");
					if (life == 0 || playerPoint < 3) {
						System.out.println("GAME OVER");
						try {
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						flag = false;
						return;
					}
					System.out.println("재도전 하시겠습니까?(yes / no)");
					String reStart = scan.nextLine();
					if (reStart.equals("yes") && playerPoint >= 3) {
						life--;
						playerPoint = playerPoint - 3;
						System.out.println("현재 남은 포인트는 " + playerPoint + "점");
						System.out.println("현재 남은 재도전 기회는 " + life + "회");
						continue;
					} else {
						flag = false;
						return;
					}
				}
				break;
			}

			if (flag == false) {
				System.out.println("점수를 저장하시려면 [save] 안하시려면 아무키나 입력하세요.");
				System.out.println(">> ");
				String yesNo = scan.nextLine();
				if (yesNo.equals("save")) {
					this.saveFile(playerPoint);
					return;
				} else {
					return;
				}
			} else if (pass == 1) {
				System.out.println("다음 문제");
				continue;
			}

		} // out while end

	}

	@Override
	public WordVO getWord() { // 무작위 한줄가져오는 method
		// TODO Auto-generated method stub
		int nSize = wordList.size(); // 리스트에 저장한만큼 사이즈를 만들고
		int num = rnd.nextInt(nSize); // 그 사이즈에서 -1 정도로 랜덤으로 값을 구해서

		WordVO wordVO = wordList.get(num); // 무작위로 나온 수의 번째에 있는 단어를 wordVO에 담고

		return wordVO; // 다시 돌려보낸다
	}

	@Override
	public void help() {
		System.out.println("=".repeat(50));
		System.out.println("도움말 및 게임규칙");
		System.out.println("1. 한 문제당 3번의 재도전이 가능하며 재도전 1번 당 5포인트 차감합니다.");
		System.out.println("2. 재도전 횟수가 남아있어도 포인트가 모자르면 재도전이 불가능합니다.");
		System.out.println("3. 마찬가지로 포인트가 있어도 재도전 기회가 없으면 재도전이 불가합니다.");
		System.out.println("4. [HELP]를 입력해 HINT를 얻을 수 있습니다.");
		System.out.println("5. HINT 한번 요청할때마다 2포인트 차감합니다.");
		System.out.println("6. PASS 입력시 다음문제로 건너뛸수있으며 이때 재도전 횟수는 초기화됩니다.");
		System.out.println("7. PASS 한번 할때마다 3포인트 차감합니다.");
		System.out.println("=".repeat(50));

	}

}
