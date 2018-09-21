#!/usr/bin/python

import sys
import pandas as pd
from scipy.stats import wilcoxon, mannwhitneyu
from numpy import mean, std # version >= 1.7.1 && <= 1.9.1
from math import sqrt

def cohen_d(x,y):
  return (mean(x) - mean(y)) / sqrt((std(x, ddof=1) ** 2 + std(y, ddof=1) ** 2) / 2.0)


if len(sys.argv) != 2:
  print("Usage: %s /path/to/statistics.csv" % sys.argv[0])
  exit(1)

df = pd.read_csv(sys.argv[1])

cat1 = df[df['configuration_id']=='Default']
cat2 = df[df['configuration_id']=='Branch']

for column in ['Size', 'Length', 'MutationScore']:
#  print "%s: %.2f (%f)" % (column, cohen_d(cat1[column], cat2[column]), wilcoxon(cat1[column], cat2[column])[1])
  print "%s: Default %.2f vs Branch %.2f: %.2f (%f)" % (column, mean(cat1[column]), mean(cat2[column]), cohen_d(cat1[column], cat2[column]), mannwhitneyu(cat1[column], cat2[column])[1])
