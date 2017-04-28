package com.hantsylabs.restexample.springmvc.test.mock;

import com.hantsylabs.restexample.springmvc.domain.Post;
import com.hantsylabs.restexample.springmvc.model.PostDetails;
import com.hantsylabs.restexample.springmvc.repository.CommentRepository;
import com.hantsylabs.restexample.springmvc.repository.PostRepository;
import com.hantsylabs.restexample.springmvc.repository.PostSpecifications;
import com.hantsylabs.restexample.springmvc.service.BlogService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore //upgrade to 1.4.1, failed.
public class MockBeanBlogServiceTest {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(MockBeanBlogServiceTest.class);
    @MockBean
    private PostRepository postRepository;

    @MockBean
    private CommentRepository comments;

    @Inject
    private BlogService blogService;

    public MockBeanBlogServiceTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllPosts() {
        PageRequest pr = new PageRequest(0, 10);
        Post post = Post.builder().id(1L).title("test post title").content("test post content@").build();
//        when(postRepository.findAll(PostSpecifications.filterByKeywordAndStatus("q", Post.Status.DRAFT), pr))
//                .thenAnswer((InvocationOnMock invocation) -> new PageImpl<>(Arrays.asList(post), pr, 1));

        given(postRepository.findAll(PostSpecifications.filterByKeywordAndStatus("q", Post.Status.DRAFT), pr))
                .willReturn(new PageImpl<>(Arrays.asList(post), pr, 1));

        Page<PostDetails> pagedPosts = blogService.searchPostsByCriteria("q", Post.Status.DRAFT, pr);
        log.debug("posts @" + pagedPosts.getContent());
        assertTrue("posts's size is 1", pagedPosts.getTotalElements() == 1);

        PostDetails result = pagedPosts.getContent().get(0);

        log.debug("paged poast details #1 @" + result);

        assertTrue(result.getTitle().equals("test post title"));
        assertTrue(result.getContent().startsWith("test post content@"));
    }
}
