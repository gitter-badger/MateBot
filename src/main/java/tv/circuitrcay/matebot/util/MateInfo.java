package tv.circuitrcay.matebot.util;

import tv.circuitrcay.matebot.util.Downloader;
import tv.circuitrcay.matebot.util.Version;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MateInfo
{
    public static final String RECOMMENDED_BUILD_ROOT = "http://home.dv8tion.net:8080/job/Yui/Promoted%20Build/artifact/build/libs/";
    public static final String BETA_BUILD_ROOT = "http://home.dv8tion.net:8080/job/Yui/lastCompletedBuild/artifact/build/libs/";
    public static final Version VERSION = new Version(
            "@versionMajor@",
            "@versionMinor@",
            "@versionRevision@",
            "@versionBuild@"
    );
    private static final String URL_REGEX = "\\<a href=\"MateBot-[0-9]*\\.[0-9]*\\.[0-9]*_[0-9]*\\.jar\">(MateBot-[0-9]*\\.[0-9]*\\.[0-9]*_[0-9]*\\.jar)\\<\\/a\\>";
    private static final String VERSION_REGEX = "MateBot-([0-9]*\\.[0-9]*\\.[0-9]*_[0-9]*)\\.jar";

    public static String getLatestRecommendedUrl()
    {
        String page = Downloader.webpage(RECOMMENDED_BUILD_ROOT);
        Pattern urlPattern = Pattern.compile(URL_REGEX);
        Matcher urlMatcher = urlPattern.matcher(page);
        if (urlMatcher.find())
        {
            return RECOMMENDED_BUILD_ROOT + urlMatcher.group(1);
        }
        else
            throw new RuntimeException("Could not find Recommended URL.");
    }

    public static String getLatestBetaUrl()
    {
        String page = Downloader.webpage(BETA_BUILD_ROOT);
        Pattern urlPattern = Pattern.compile(URL_REGEX);
        Matcher urlMatcher = urlPattern.matcher(page);
        if (urlMatcher.find())
        {
            return BETA_BUILD_ROOT + urlMatcher.group(1);
        }
        else
            throw new RuntimeException("Could not find Beta URL.");
    }

    public static Version getLatestRecommendedVersion()
    {
        String url = getLatestRecommendedUrl();
        Pattern verPattern = Pattern.compile(VERSION_REGEX);
        Matcher verMatcher = verPattern.matcher(url);
        if (verMatcher.find())
        {
            return new Version(verMatcher.group(1));
        }
        else
            throw new RuntimeException("Could not find Recommended version from URL. URL: " + url);
    }

    public static Version getLatestBetaVersion()
    {
        String url = getLatestBetaUrl();
        Pattern verPattern = Pattern.compile(VERSION_REGEX);
        Matcher verMatcher = verPattern.matcher(url);
        if (verMatcher.find())
        {
            return new Version(verMatcher.group(1));
        }
        else
            throw new RuntimeException("Could not find Beta version from URL. URL: " + url);
    }

    public static boolean hasNewRecommendedVersion()
    {
        return VERSION.olderThan(getLatestRecommendedVersion());
    }

    public static boolean hasNewBetaVersion()
    {
        return VERSION.olderThan(getLatestBetaVersion());
    }
}
