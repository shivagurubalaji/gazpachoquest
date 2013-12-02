package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.domain.core.LabelSet;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("LabelSetRepository-dataset.xml")
public class LabelSetRepositoryTest {

    @Autowired
    private LabelSetRepository labelSetRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Test
    public void saveTest() {
        LabelSet labelSet = new LabelSet();
        labelSet.setLanguage(Language.EN);
        labelSet.setName("Feelings");

        LabelSet created = labelSetRepository.saveAndFlush(labelSet);
        LabelSet detached = new LabelSet();
        detached.setId(created.getId());

        Label label = new Label();
        label.setLabelSet(created);
        label.setLanguage(Language.EN);
        label.setTitle("Totally agree");
        label = labelRepository.saveAndFlush(label);
        
        assertThat(label.getId()).isNotNull();
        assertThat(label.getLabelSet()).isNotNull();
        assertThat(label.getLabelSet().getName()).isEqualTo(labelSet.getName());
    }
}
