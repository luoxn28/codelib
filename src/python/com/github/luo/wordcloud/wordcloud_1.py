import jieba
from wordcloud import WordCloud

# 不建议进行分词的特殊名词
jieba.suggest_freq(('微博'), True)
jieba.suggest_freq(('热搜'), True)

# 获取过滤停顿词 获取待分词数据
stopwords = {}.fromkeys(open('./utils/stop_words_zh.txt').read().split("\n"))
tokens = jieba.cut(open('/tmp/book/第一章').read())
# 分词清洗 过滤停顿词和空白分词
tokens = [v for v in tokens if (v not in stopwords) and (v.strip() != '')]

result = ",".join(tokens)
print(result)

wc = WordCloud(
    background_color="white",  # 背景颜色
    max_words=200,  # 显示最大词数
    font_path="./utils/simhei.ttf",  # 使用中文字体
    min_font_size=15,
    max_font_size=50,
    height=400,
    width=800
).generate(result)
wc.to_file("wordcloud.png")
