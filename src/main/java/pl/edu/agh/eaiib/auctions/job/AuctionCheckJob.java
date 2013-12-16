package pl.edu.agh.eaiib.auctions.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class AuctionCheckJob extends QuartzJobBean {

	private FinishAuctionTask task;
	 
	public void setFinishAuctionTask(FinishAuctionTask runMeTask) {
		this.task = runMeTask;
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		task.run(context);
		
	}

}
