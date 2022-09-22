package test;


public class AppleWatch implements Watchs{
	public AppleWatch() {
		System.out.println("애플워치 연동완료");
	}

	@Override
	public void volumeUp() {
		System.out.println("애플워치 볼륨 ++");		
	}

	@Override
	public void volumeDown() {
		System.out.println("애플워치 볼륨 --");		
	}

}
