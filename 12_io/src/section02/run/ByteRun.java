package section02.run;

import section02.service.ByteService;

public class ByteRun {
	public static void main(String[] args) {
		ByteService service =new ByteService();
		/*파일 출력*/
//		service.fileByteOutput();
//		service.bufferedFileByteOutput();
		/*파일 입력*/
//		service.fileByteInput();
//		service.fileByteInput2();
//		service.bufferedFileByteInput();
		/*파일 copy*/
		service.fileCopy();
	}
}