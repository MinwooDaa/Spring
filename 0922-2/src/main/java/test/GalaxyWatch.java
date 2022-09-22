package test;


public class GalaxyWatch implements Watchs{
	public GalaxyWatch() {
		System.out.println("갤럭시 워치 연동완료");
	}

	@Override
	public void volumeUp() {
		System.out.println("갤럭시 워치 볼륨 ++");
	}

	@Override
	public void volumeDown() {
		System.out.println("갤럭시 워치 볼륨 --");		
	}

}
