package config;

import org.apache.tomcat.util.scan.JarFactory;
import org.apache.xerces.impl.xpath.XPath.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.demo.modal.Train;

@Configuration
public class SpringBatchConfig
{
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
            ItemReader<Train> itemReader, ItemProcessor<Train, Train> itemProcessor,
            ItemWriter<Train> itemWriter) {

 TaskletStep step = stepBuilderFactory.get("ETL-load")
                               .<Train, Train>chunk(100) // chunk size
                               .reader(itemReader)
                               .processor(itemProcessor)
                               .writer(itemWriter)
                               .build();

 return jobBuilderFactory.get("ETL-Load")
                         .incrementer(new RunIdIncrementer())
                         .start(step)
                         .build();
		
	}

}
