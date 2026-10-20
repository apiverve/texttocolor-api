from setuptools import setup, find_packages

setup(
    name='apiverve_texttocolor',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Text to Color converts natural language color names into hexadecimal color codes. Send descriptive color phrases to receive matching hex values and channel counts, with paid plans adding RGB, HSL, and CMYK formats.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/texttocolor?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
