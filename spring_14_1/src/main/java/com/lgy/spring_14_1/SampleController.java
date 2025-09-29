package com.lgy.spring_14_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgy.spring_14_1.domain.MemberVO;
import com.lgy.spring_14_1.domain.SampleVO;
import com.lgy.spring_14_1.domain.TicketVO;

import lombok.extern.slf4j.Slf4j;

//@Controller
@RestController //pom.xml 설정되어야 사용 가능
@RequestMapping("/sample")
@Slf4j
public class SampleController {
//	xml 이나 json 데이터 안 나올 때 추가(MediaType~)
//	@GetMapping(value = "/getSample")
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		return IntStream.range(1, 10)
				.mapToObj(i->new SampleVO(i, i+"First", i+"Last")).collect(Collectors.toList());
		
	}
	
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		return map;
	}
	
	@GetMapping(value = "/check", params = {"height", "weight"})
//	ResponseEntity : 데이터 + http 상태 코드를 전달
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO vo = new SampleVO(0, height+"", weight+"");
		ResponseEntity<SampleVO> result = null;
		
		if (height < 150) {
//			HttpStatus.BAD_GATEWAY : http 오류 상태
//			http://localhost:8181/spring_14_1/sample/check?height=140&weight=40
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
//			HttpStatus.OK : http 정상 상태
//			http://localhost:8181/spring_14_1/sample/check?height=160&weight=50 콘솔창에 비어있음
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}

	@GetMapping(value = "/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable int pid) {
		return new String[] {"category : "+cat, "product id : "+pid};
	}
	
	@PostMapping("/ticket")
//	public void convert(TicketVO ticketVO) {
//	@RequestBody: 전송된 json 데이터를 TicketVO 타입의 객체로 변환
//	public void convert(@RequestBody TicketVO ticketVO) {
	public TicketVO convert(@RequestBody TicketVO ticketVO) {
		System.out.println("@# ticketVO111 => " + ticketVO);
		log.info("@# ticketVO222 =>" + ticketVO);
		
		return ticketVO;
	}

	
	@PostMapping("/info")
	public MemberVO convert(@RequestBody MemberVO memberVO) {
		System.out.println("@# ticketVO111 => " + memberVO);
		log.info("@# ticketVO222 =>" + memberVO);
		
		return memberVO;
	}
}
