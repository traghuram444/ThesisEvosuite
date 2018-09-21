#!/usr/bin/python

import sys
import matplotlib.pyplot as plt
import pandas as pd

if len(sys.argv) != 2:
    print("Usage: %s /path/to/statistics.csv" % sys.argv[0])
    exit(1)

df = pd.read_csv(sys.argv[1])
bp = df.boxplot(column='Size', by='configuration_id')
bp = df.boxplot(column='Length', by='configuration_id')
bp = df.boxplot(column='MutationScore', by='configuration_id')
plt.show()