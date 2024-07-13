//package com.example.demo.Test;
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.example.demo.controller.UserController;
//import com.example.demo.modal.Train;
//import com.example.demo.repository.TrainRepository;
//
//@WebMvcTest(UserController.class)
//public class UserControllerTest 
//{
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private TrainRepository trainRepository;
//	
//	@BeforeEach
//	public void setUp()
//	{
//		MockitoAnnotations.openMocks(this);
//	}
//	
//	
//	@Test
//	public void testFindTrainBySourceAndDestination() throws Exception {
//        Train train = new Train(1L, "New York", "Boston", 123);
//        when(trainRepository.findTrainBySourceAndDestination("New York", "Boston"))
//                .thenReturn(Arrays.asList(train));
//        
//        mockMvc.perform(get("/usr/search")
//                .param("source", "New York")
//                .param("destination", "Boston"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("[Train [id=1, source=New York, destination=Boston, trainNumber=123]]"));
//    }
//
// 
//}
