
measureA <- function(a,b){

	if(length(a)==0 & length(b)==0){
		return(0.5)
	} else if(length(a)==0){
		## motivation is that we have no data for "a" but we do for "b".
		## maybe the process generating "a" always fail (eg out of memory)
		return(0)
	} else if(length(b)==0){
		return(1)
	}

	r = rank(c(a,b))
	r1 = sum(r[seq_along(a)])

	m = length(a)
	n = length(b)
	A = (r1/m - (m+1)/2)/n

	return(A)
}

boxPlot <- function(default, branch, name) {
    data = list(default, branch)

    xlabels = c("Default", "Branch")
    
    pdf(file=paste("boxplot_",name,".pdf",sep=""), width=6, height=5, family ="Helvetica",fonts = "Helvetica")			
	
    boxplot(data, names=xlabels, xlab="", ylab=name)    
    dev.off();
}

analyse <- function(default, branch, name) {
    w = wilcox.test(default, branch, exact=FALSE, paired=FALSE)
    pv = w$p.value
    cat(paste(name, ": Default=", format(mean(default),digit=2,nsmall=2), ", Branch=", format(mean(branch),digit=2,nsmall=2), ", A12=", format(measureA(default, branch),digit=2,nsmall=2), ", p=", format(pv, digit=2,nsmall=2), "\n", sep=""))
}


args <- commandArgs(trailingOnly = TRUE)
if (length(args)!=1) {
    stop("usage: Rscript analysis.R <data_file>")
}

stats = args[1]

data = read.csv(stats)

size_default <- data$Size[data$configuration_id=='Default']
size_branch  <- data$Size[data$configuration_id=='Branch']
analyse(size_default, size_branch, "Size")

length_default <- data$Length[data$configuration_id=='Default']
length_branch  <- data$Length[data$configuration_id=='Branch']
analyse(length_default, length_branch, "Length")

score_default <- data$MutationScore[data$configuration_id=='Default']
score_branch  <- data$MutationScore[data$configuration_id=='Branch']
analyse(score_default, score_branch, "MutationScore")

boxPlot(size_default, size_branch, "Size")
boxPlot(length_default, length_branch, "Length")
boxPlot(score_default, score_branch, "MutationScore")
