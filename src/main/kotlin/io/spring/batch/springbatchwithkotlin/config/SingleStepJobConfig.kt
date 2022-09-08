package io.spring.batch.springbatchwithkotlin.config

import mu.KotlinLogging
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

private val log = KotlinLogging.logger {}

@Configuration
@ComponentScan("org.springframework.batch.core.configuration.annotation")
class SingleStepJobConfig(private val jobBuilderFactory: JobBuilderFactory,
                          private val stepBuilderFactory: StepBuilderFactory
){

    @Bean
    fun job(): Job {
        log.info { "=======job 실행, step() 실행=======" }
        return this.jobBuilderFactory.get("job")
            .start(step())
            .build()
    }

    @Bean
    fun step(): Step {
        log.info { "=======step 메서드 실행, stepBuilderFactory.get(''stepName'') 을 통해 태스크를 가져옴. =======" }
        return this.stepBuilderFactory.get("step1")
            .tasklet(Tasklet { contribution: StepContribution, chunkContext: ChunkContext ->
                log.info { "HELLO WORLD!!!!!!!!!" }
                RepeatStatus.FINISHED
            })
            .build()
    }
}