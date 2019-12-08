package com.expense.service.impl.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.expense.dao.CategoryListDao;
import com.expense.entity.CategoryListEntity;
import com.expense.service.TransactionService;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImplTest {
	
	
	@Mock
	CategoryListDao categoryListDaoMock;
	
	@InjectMocks
	TransactionService transactionServiceMock;
	
	private MockMvc mockMvc;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(transactionServiceMock).build();
	}
	
	@Test
	public void testFindTheGreatestFromAllData() {
	
		/*when(categoryListDaoMock.findByUserDetailsId(4L)).thenReturn(new CategoryListEntity());
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(24, result);*/
	}


}
